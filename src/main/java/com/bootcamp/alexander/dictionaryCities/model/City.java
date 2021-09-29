package com.bootcamp.alexander.dictionaryCities.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name="DictionaryCities")
/**
* Класс город,который содержит информацию такую как:
* Имя города, наименование региона в котором город находится,
* наименование федерального коруга в котором находится,
* количество населения, дату основания.
* Содержащий перегрузку методов:
* equals(), hashCode(), toString
* */
public class City {

    @Id
    @SequenceGenerator(name = "city_generator", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_generator")

    private  String name;//Наименование города
    private  String region;//Наименования региона
    private  String district;//Федеральный округ
    private  int population;//Количество населения в городе
    private  String foundation;//Дата основания или первое упоминание

    public City(){}
    public City(String[] fields){
        //Проверка полей
        if(fields[1] != null && fields[2] != null &&
           fields[3] != null && Integer.parseInt(fields[4]) != 0 && fields[5] != null ){
            this.name = fields[1];
            this.region = fields[2];
            this.district = fields[3];
            this.population = Integer.parseInt(fields[4]);
            this.foundation = fields[5];
        }
    }

    /**
     * Геттеры , сеттеры
     */

    public String getName(){
        return name;
    }

    public String getRegion(){
        return region;
    }

    public String getDistrict(){
        return district;
    }

    public int getPopulation(){
        return population;
    }

    public String getFoundation(){
        return foundation;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, region, district, population, foundation);
    }

    @Override
    public String toString(){
        return "{City" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        City city = (City)o;
        return name.equals(city.name) && region.equals(city.region) && district.equals(city.district) &&
                population == city.population && foundation.equals(city.foundation);
    }
}
