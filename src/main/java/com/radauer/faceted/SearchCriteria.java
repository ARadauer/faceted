package com.radauer.faceted;

import java.util.Map;

/**
 * Created by Andreas on 16.04.2017.
 */
public class SearchCriteria {
    private String attribute;
    private Map<String, SearchItem> searchItems;

    public SearchCriteria(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Map<String, SearchItem> getSearchItems() {
        return searchItems;
    }

    public void setSearchItems(Map<String, SearchItem> searchItems) {
        this.searchItems = searchItems;
    }

    @Override
    public String toString() {
        return "\n SearchCriteria:" + attribute + '\'' +
                ", searchItems=" + searchItems
                ;
    }
}
