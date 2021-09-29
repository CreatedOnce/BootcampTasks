package com.bootcamp.alexander.dictionaryCities.manager;

import com.bootcamp.alexander.dictionaryCities.dao.CityDAO;
import com.bootcamp.alexander.dictionaryCities.model.City;
import com.bootcamp.alexander.dictionaryCities.service.*;
import com.bootcamp.alexander.dictionaryCities.util.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.io.File;

public class Manager {

    public static Sorter sorter = new Sorter();
    private static String FILE_PATH = "src/main/resources/DictionaryCities.txt";
    private static List<City> listCit;
    public static void menu() {

        List<City> listCity = ParserCitites.parserCity(new File(FILE_PATH), listCit);
        CityDAO cityDAO = new CityDAO();
        cityDAO.insertCitiesInDatabse(listCity);
        dispplayMenuItems();
        Scanner in = new Scanner(System.in);

        boolean check = false;
        int choice;
        try {
            while ((choice = in.nextInt()) != 0) {
                switch (choice) {

                    case 1:
                        System.out.println("\nСписок городов:");
                        displayCities(listCity);
                        dispplayMenuItems();
                        break;
                    case 2:
                        System.out.println(": \n");
                        sortedCityByName(listCity);
                        dispplayMenuItems();
                        break;
                    case 3:
                        sortedByDistrict(listCity);
                        dispplayMenuItems();
                        break;
                    case 4:
                        System.out.println(": \n");
                        getMaxCityPopulation(listCity);
                        dispplayMenuItems();
                        break;
                    case 5:
                        System.out.println(": \n");
                        countOfCitiesByDistrict(listCity);
                        dispplayMenuItems();
                        break;
                    case 6:
                        choice = 0;

                    default:
                        System.out.println("Not correct input\n");
                        dispplayMenuItems();
                }
            }
        } catch(InputMismatchException e){
                System.out.println("Not correct input!");
                e.printStackTrace();
            }
    }

    //Module 1
    public static void displayCities(List<City> cities) {
        cities.forEach(System.out::println);
    }

    //Module 2
    public static void sortedCityByName(List<City> cities) {
        sorter.setComparator(Comparators.cityByNameComparator);
        sorter.sort(cities);
        System.out.println("\nСортировка списка городов по названию." +
                "в алфавитном порядке по убыванию без учета регистра");
        cities.forEach(System.out::println);
    }

    //Module 3
    public static void sortedByDistrict(List<City> cities) {
        sorter.setComparator(Comparators.cityByDistrictThenByNameComparator);
        sorter.sort(cities);
        System.out.println("\nСортировка списка городов " +
                "по федеральному округу и наименованию " +
                "города в алфавитном порядке по убыванию" +
                "с учетом регистра. ");
        cities.forEach(System.out::println);
    }

    //Module 4
    public static void getMaxCityPopulation(List<City> cities) {
        int[] maxPopulation = Algorithms.findCityHighestPopulation(cities);
        System.out.printf("\nГород с максимальным населением:\n[%d] = %d\n", maxPopulation[0], maxPopulation[1]);
    }

    //Module5
    public static void countOfCitiesByDistrict(List<City> cities) {
        Map<String, Integer> citiesNumberByRegions = Algorithms.getCitiesNumberByRegion(cities);
        System.out.println("\nКоличество городов по регионам:");
        citiesNumberByRegions.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public static void dispplayMenuItems() {
        System.out.println("\nВыберите требуемое действие:");
        System.out.println("1 - Список городов.");
        System.out.println("2 - Сортировка списка городов " +
                               "по наназванию в алфавитном порядке по " +
                               "убыванию без учета регистра.");
        System.out.println("3 - Сортировка списка городов " +
                                "по федеральному округу и наименованию " +
                                "города в алфавитном порядке по убыванию " +
                                "с учетом регистра.");
        System.out.println("4 - Максимальное количество жителей.");
        System.out.println("5 -  Количество городов в разрезе регионов.");
        System.out.println("6 - Выход.");
    }

}
