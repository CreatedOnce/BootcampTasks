package com.bootcamp.alexander.dictionaryCities.service;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Comparator<City> comparator = Comparator.comparing(City::getName);

    public void setComparator(Comparator<City> comparator){
        this.comparator = comparator;
    }

    public void sort(List<City> list){
        list.sort(comparator);
    }
}
