package com.hibernate.p05_identifier_generation.zconfig;

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
                settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
                settings.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/praveenDB");
                settings.put("hibernate.connection.username", "postgres");
                settings.put("hibernate.connection.password", "root");

                settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                settings.put("hibernate.hbm2ddl.auto", "update");
                settings.put("hibernate.show_sql", true);

                ServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .applySettings(settings)
                        .build();

                sessionFactory = new MetadataSources(registry)
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(com.hibernate.p05_identifier_generation.identity.entity.IdentityStudent.class)
                        .addAnnotatedClass(com.hibernate.p05_identifier_generation.sequence.entity.SequenceStudent.class)
                        .addAnnotatedClass(com.hibernate.p05_identifier_generation.embeddedid.entity.Employee.class)
                        .addAnnotatedClass(com.hibernate.p05_identifier_generation.idclass.key.CourseEnrollment.class)
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
