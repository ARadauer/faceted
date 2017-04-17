package com.radauer.faceted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andreas on 16.04.2017.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<Car> cars = new ArrayList<>();
        String[] brands = {"VW", "AUDI", "SEAT", "SKODA"};
        String[] fuels = {"Diesel", "Diesel", "Diesel", "Benzin", "Benzin", "Elektro"};
        String[] gears = {"Man", "Man", "Auto"};

        for (int i = 0; i < 1000; i++) {
            for (String brand : brands) {
                for (String fuel : fuels) {
                    for (String gear : gears) {

                        cars.add(new Car(brand, fuel, gear, new String[]{"Cabrio"}));
                    }
                }
            }
        }

        System.out.println("Car " + cars.size());


        String[] facets = {"brand", "fuel", "geartype", "chassyTypes"};

        SearchService searchService = new SearchService();

        searchService.index(cars, facets);


        long t = System.currentTimeMillis();
        ;
        SearchResponse response = searchService.search(Arrays.asList(new SearchParameter("fuel", new String[]{"Diesel"})));
        System.out.println(response);
        System.out.println((System.currentTimeMillis() - t) + " ms");


    }
}
