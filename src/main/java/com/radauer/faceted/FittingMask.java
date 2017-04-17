package com.radauer.faceted;

/**
 * Created by Andreas on 17.04.2017.
 */
public class FittingMask {

    boolean[] values;

    public FittingMask(int size) {
        values = new boolean[size];
        reset();
    }

    public void reset() {
        for (int i = 0; i < values.length; i++) {
            values[i] = true;
        }
    }

    public void setFit(int position, boolean fits) {
        values[position] = fits;
    }

    public boolean fitsAll() {
        for (boolean fits : values) {
            if (!fits) {
                return false;
            }
        }
        return true;

    }

    public boolean fitsAllIgnoreCurrent(int current) {
        for(int i =0; i < values.length ; i++){
            if (!values[i] && i != current) {
                return false;
            }
        }
        return true;
    }
}
