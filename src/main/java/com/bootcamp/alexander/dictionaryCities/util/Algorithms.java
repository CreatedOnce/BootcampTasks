package com.bootcamp.alexander.dictionaryCities.util;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Algorithms {
    private Algorithms(){}

    /**
     * Находит индекс элемента и значение с наибольшим количеством жителей города
     */
    public static int[] findCityHighestPopulation(List<City> cities){
        if(cities.isEmpty()){
            return new int[]{0,0};
        }

        City[] cityArray = cities.toArray(new City[0]);
        int maxIndex = 0;
        for(int i = 0; i < cityArray.length; ++i){
            if(cityArray[i].getPopulation() > cityArray[maxIndex].getPopulation()){
                maxIndex = i;
            }
        }

        return new int[]{maxIndex, cityArray[maxIndex].getPopulation()};
    }

    public static Map<String, Integer> getCitiesNumberByRegion(List<City> cities){
        Map<String, Integer> map = new HashMap<>();
        for (City city:cities) {
            String currentRegion = city.getRegion();
            if(map.containsKey(currentRegion)){
                map.put(currentRegion, map.get(currentRegion)+1);
            } else{
                map.put(currentRegion,1);
            }
        }
        return  map;
    }
}
