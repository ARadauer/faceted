package com.radauer.faceted.base;

import java.util.Map;

/**
 * Created by Andreas on 17.04.2017.
 */
public class Document <TYPE> {
    private TYPE subject;
    private Map<String, String[]> facets;

    public Document(TYPE car, Map<String, String[]> facets) {
        this.subject = car;
        this.facets = facets;
    }

    public TYPE getSubject() {
        return subject;
    }

    public void setSubject(TYPE subject) {
        this.subject = subject;
    }

    public Map<String, String[]> getFacets() {
        return facets;
    }

    public void setFacets(Map<String, String[]> facets) {
        this.facets = facets;
    }
}
