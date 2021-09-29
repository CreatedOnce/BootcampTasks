package com.bootcamp.alexander.dictionaryCities.util;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.util.Comparator;

public class Comparators {
    private Comparators(){};

    public static final Comparator<City> cityByNameComparator =(c1 , c2) -> c1.getName().compareToIgnoreCase(c2.getName());

    public static final Comparator<City> cityByDistrictThenByNameComparator = (c1 , c2) -> {
        if(c1.getDistrict().compareTo(c2.getDistrict()) == 0){
            return c1.getName().compareTo(c2.getName());
        }

        return c1.getDistrict().compareTo(c2.getDistrict());
    };
}
