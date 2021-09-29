package com.bootcamp.alexander.dictionaryCities.dao;

import com.bootcamp.alexander.dictionaryCities.model.City;

import com.bootcamp.alexander.dictionaryCities.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.PersistenceException;
import java.util.List;

public class CityDAO {
    public void insertCitiesInDatabse(List<City> cities){
        try{
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            for (City city:cities) {
                session.save(city);
            }
            transaction.commit();
            session.close();

        }catch (PersistenceException e){
            System.out.println("База данных заполнена! Выбирайте пункт меню:\n");
        }
    }

    public List<City> getListCities(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select * from DictionaryCities", City.class).getResultList();

    }

}
