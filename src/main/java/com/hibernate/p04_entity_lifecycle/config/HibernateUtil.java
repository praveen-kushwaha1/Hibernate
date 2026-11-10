package com.hibernate.p04_entity_lifecycle.config;

import com.hibernate.p03_annotation_configuration.entity.User;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Map<String, Object> settings = new HashMap<>();

                // ✅ Use string-based keys (recommended for Hibernate 6.x)
                settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
                settings.put("hibernate.connection.username", "root");
                settings.put("hibernate.connection.password", "root");

                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                settings.put("hibernate.hbm2ddl.auto", "update");
                settings.put("hibernate.show_sql", true);

                ServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .applySettings(settings)
                        .build();

                sessionFactory = new MetadataSources(registry)
                        .addAnnotatedClass(Student.class)
                        .buildMetadata()
                        .buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
