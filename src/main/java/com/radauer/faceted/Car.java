package com.radauer.faceted;

import java.util.UUID;

/**
 * Created by Andreas on 16.04.2017.
 */
public class Car {
    private String id;
    private String brand;
    private String fuel;
    private String geartype;
    private String[] chassyTypes;

    public Car(String brand, String fuel, String geartype, String[] chassyTypes) {
        id = UUID.randomUUID().toString();
        this.brand = brand;
        this.fuel = fuel;
        this.geartype = geartype;
        this.chassyTypes = chassyTypes;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGeartype() {
        return geartype;
    }

    public void setGeartype(String geartype) {
        this.geartype = geartype;
    }

    public String[] getChassyTypes() {
        return chassyTypes;
    }

    public void setChassyTypes(String[] chassyTypes) {
        this.chassyTypes = chassyTypes;
    }
}
