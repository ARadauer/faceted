package com.radauer.faceted;

import java.util.Map;

/**
 * Created by Andreas on 17.04.2017.
 */
public class Document {
    private Car car;
    private Map<String, String[]> facets;

    public Document(Car car, Map<String, String[]> facets) {
        this.car = car;
        this.facets = facets;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map<String, String[]> getFacets() {
        return facets;
    }

    public void setFacets(Map<String, String[]> facets) {
        this.facets = facets;
    }
}
