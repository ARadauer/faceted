package com.radauer.faceted;

import org.apache.commons.lang.ArrayUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Andreas on 16.04.2017.
 */
public class SearchService {

    private List<Document> documents;
    private String[] facets;

    public void index(List<Car> cars, String[] facets) throws Exception {
        this.facets = facets;
        documents = new ArrayList<>();


        Map<String, Method> methodMap = createMethodMap(facets);


        for (Car car : cars) {
            documents.add(indexCar(car, methodMap));
        }
    }

    private Document indexCar(Car car, Map<String, Method> methodMap) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        Map<String, String[]> facets = new HashMap<>();
        for (String facet : methodMap.keySet()) {
            Method method = methodMap.get(facet);
            Object value = method.invoke(car);
            String[] result = value instanceof String[] ? (String[]) value : new String[]{(String) value};
            facets.put(facet, result);

        }
        return new Document(car, facets);
    }

    private Map<String, Method> createMethodMap(String[] facets) throws IntrospectionException {
        Map<String, Method> methodMap = new HashMap<>();
        for (String facet : facets) {
            methodMap.put(facet, new PropertyDescriptor(facet, Car.class).getReadMethod());
        }
        return methodMap;

    }

    public SearchResponse search(List<SearchParameter> parameter) {


        Map<String, SearchCriteria> criterias = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        Map<String, SearchParameter> mappedParameter = mapParameter(parameter);


        FittingMask fitsFacets = new FittingMask(facets.length);
        for (Document doc : documents) {
            fitsFacets.reset();

            for (int i = 0; i < facets.length; i++) {
                String facet = facets[i];

                String[] valuesForFacet = doc.getFacets().get(facet);
                SearchParameter searchParameter = mappedParameter.get(facet);
                if(searchParameter != null){
                    boolean fits = doesValuesFitParameter(valuesForFacet, searchParameter.getValues());
                    fitsFacets.setFit(i, fits);
                }
            }

            if(fitsFacets.fitsAll()){
                cars.add(doc.getCar());
            }


            for (int i = 0; i < facets.length; i++) {
                String facet = facets[i];

                if(fitsFacets.fitsAllIgnoreCurrent(i)){
                    SearchCriteria searchCriteria = getCriteria(facet, criterias);

                    String[] valuesForFacet = doc.getFacets().get(facet);
                    addValuesToCriteria(valuesForFacet, searchCriteria);
                }





            }


        }

        return new SearchResponse(parameter, new ArrayList<>(criterias.values()), cars);
    }

    private Map<String, SearchParameter> mapParameter(List<SearchParameter> parameter) {
        Map<String, SearchParameter> mapedParameter = new HashMap<>();
        if(parameter != null){
            for (SearchParameter param : parameter) {
                if (mapedParameter.containsKey(param.getAttribute())) {

                    SearchParameter exisingParam = mapedParameter.get(param.getAttribute());

                    Set<String> values = new HashSet<>();
                    Collections.addAll(values, param.getValues());
                    Collections.addAll(values, exisingParam.getValues());
                    exisingParam.setValues(values.toArray(new String[values.size()]));
                } else {
                    mapedParameter.put(param.getAttribute(), param);
                }
            }
        }

        return mapedParameter;
    }

    private boolean doesValuesFitParameter(String[] values, String[] parameter) {
        for (String param : parameter) {
            if (!ArrayUtils.contains(values, param)) {
                return false;
            }
        }
        return true;
    }


    private void addValuesToCriteria(String[] valuesForFacet, SearchCriteria searchCriteria) {
        for (String value : valuesForFacet) {
            addValueToCriteria(value, searchCriteria);
        }
    }

    private void addValueToCriteria(String value, SearchCriteria searchCriteria) {
        if (searchCriteria.getSearchItems() == null) {
            searchCriteria.setSearchItems(new HashMap<String, SearchItem>());
        }
        SearchItem item = searchCriteria.getSearchItems().get(value);
        if (item == null) {
            item = new SearchItem(value);
            searchCriteria.getSearchItems().put(value, item);
        }
        item.setCount(item.getCount() + 1);
    }

    private SearchCriteria getCriteria(String facet, Map<String, SearchCriteria> criterias) {
        SearchCriteria criteria = criterias.get(facet);
        if (criteria == null) {
            criteria = new SearchCriteria(facet);
            criterias.put(facet, criteria);
        }
        return criteria;
    }


}
