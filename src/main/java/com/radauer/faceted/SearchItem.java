package com.radauer.faceted;

/**
 * Created by Andreas on 17.04.2017.
 */
public class SearchItem {
    private String value;
    private int count;

    public SearchItem(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\n  "+ value + ':' + count;
    }
}
