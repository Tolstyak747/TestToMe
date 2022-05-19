package com.Malkov.hibernate;

import com.Malkov.domain.Device;
import com.Malkov.domain.Event;
import com.Malkov.domain.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/testToMe");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "R18081995");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.SHOW_SQL, "true");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Project.class);
                configuration.addAnnotatedClass(Device.class);
                configuration.addAnnotatedClass(Event.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        return sessionFactory;
    }
}
