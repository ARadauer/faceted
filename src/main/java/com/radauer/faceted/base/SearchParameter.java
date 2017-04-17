package com.radauer.faceted.base;

/**
 * Created by Andreas on 16.04.2017.
 */
public class SearchParameter {

    private String attribute;
    private String[] values;

    public SearchParameter(String attribute, String[] values) {
        this.attribute = attribute;
        this.values = values;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
