package com.hibernate.p06_mapping_relationships.onetomany.uni.config;



import com.hibernate.p06_mapping_relationships.onetomany.uni.entity.Department;

import com.hibernate.p06_mapping_relationships.onetomany.uni.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Department.class);

        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "root");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.show_sql", "true");

        sessionFactory = cfg.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
