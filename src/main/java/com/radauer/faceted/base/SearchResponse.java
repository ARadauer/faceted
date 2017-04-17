package com.radauer.faceted.base;

import java.util.List;

/**
 * Created by Andreas on 16.04.2017.
 */
public class SearchResponse <TYPE> {
    List<SearchParameter> searchParameter;
    List<SearchCriteria> searchCriterias;
    List<TYPE> result;

    public SearchResponse(List<SearchParameter> searchParameter, List<SearchCriteria> searchCriterias, List<TYPE> result) {
        this.searchParameter = searchParameter;
        this.searchCriterias = searchCriterias;
        this.result = result;
    }

    public List<SearchParameter> getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(List<SearchParameter> searchParameter) {
        this.searchParameter = searchParameter;
    }

    public List<SearchCriteria> getSearchCriterias() {
        return searchCriterias;
    }

    public void setSearchCriterias(List<SearchCriteria> searchCriterias) {
        this.searchCriterias = searchCriterias;
    }

    public List<TYPE> getResult() {
        return result;
    }

    public void setResult(List<TYPE> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "\nsearchParameter=" + searchParameter +
                ",\nsearchCriterias=" + searchCriterias +
                ",\n subjects=" + result.size() +
                '}';
    }
}
