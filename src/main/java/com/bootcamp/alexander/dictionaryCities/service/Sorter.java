package com.bootcamp.alexander.dictionaryCities.service;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Comparator<City> comparator = Comparator.comparing(City::getName);
}
