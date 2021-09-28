package com.bootcamp.alexander.dictionaryCities.service;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;

public class ParserCitites {
    public static void parser(File dictionaryCities, List<City> cities){
        try(Scanner in = new Scanner(dictionaryCities)){
            while(in.hasNextLine()){
                String[] currentCityInfo = in.nextLine().split(";",6);
                City currentCity = new City(currentCityInfo);
                cities.add(currentCity);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
