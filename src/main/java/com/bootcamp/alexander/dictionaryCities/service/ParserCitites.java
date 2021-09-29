package com.bootcamp.alexander.dictionaryCities.service;

import com.bootcamp.alexander.dictionaryCities.model.City;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Считывает данные из файла и разбивает их в файл
 * @param file - файл, содержащий информацию о городах
 * @param cities - список для добавления городов
 */
public class ParserCitites {
    public static List<City> parserCity(File file, List<City> cities){
        List<City> listCities = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("src/main/resources/DirectoryOfCities.txt"))){
            while(scanner.hasNextLine()){
                String[] currentCityInfo = scanner.nextLine().split(";",6);
                City currentCity = new City(currentCityInfo);
                listCities.add(currentCity);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return listCities;
    }
}
