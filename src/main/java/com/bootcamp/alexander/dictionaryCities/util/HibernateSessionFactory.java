package com.bootcamp.alexander.dictionaryCities.util;

import com.bootcamp.alexander.dictionaryCities.model.City;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory(){}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration =  new Configuration().configure();
                configuration.addAnnotatedClass(City.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e){
                System.out.println("Hibernate session factory error!");
            }
        }

        return  sessionFactory;
    }
}
