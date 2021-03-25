package com.maktab.services;

import com.maktab.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(ParcelPost.class);
            configuration.addAnnotatedClass(Recipient.class);
            configuration.addAnnotatedClass(PostOrder.class);
            configuration.addAnnotatedClass(HistoryOrder.class);
            configuration.setProperties(new Properties() {
                {
                    put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                    put("hibernate.connection.url", "jdbc:mysql://localhost:3306/transportation_management_system");
                    put("hibernate.connection.username", "root");
                    put("hibernate.connection.password", "root");
                    put("hibernate.hbm2ddl.auto", "update");
                    put("hibernate.show_sql", "true");
                }
            });
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
