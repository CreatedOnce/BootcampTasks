package com.bootcamp.alexander.dictionaryCities.util;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.util.Comparator;

/**
 * Реализация компараторов
 * */
public class Comparators {
    private Comparators(){};

    //Сравнение имен городов
    public static final Comparator<City> cityByNameComparator =(c1 , c2) -> c1.getName().compareToIgnoreCase(c2.getName());

    //Сравнение имен федлеральных округов
    public static final Comparator<City> cityByDistrictThenByNameComparator = (c1 , c2) -> {
        if(c1.getDistrict().compareTo(c2.getDistrict()) == 0){
            return c1.getName().compareTo(c2.getName());
        }

        return c1.getDistrict().compareTo(c2.getDistrict());
    };
}
