package com.hibernate.p13_caching.second_level.util;

import com.hibernate.p13_caching.second_level.entity.Employee;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.net.URL;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();

            cfg.addAnnotatedClass(Employee.class);

            // Database configuration.
            cfg.setProperty("hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver");

            cfg.setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/hibernate");

            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "root");

            cfg.setProperty("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");

            cfg.setProperty("hibernate.hbm2ddl.auto", "update");

            // SQL logging.
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");

            // Enable second-level cache.
            cfg.setProperty("hibernate.cache.use_second_level_cache", "true");

            // Configure JCache region factory.
            cfg.setProperty("hibernate.cache.region.factory_class",
                    "org.hibernate.cache.jcache.JCacheRegionFactory");

            // Configure Ehcache provider.
            cfg.setProperty("hibernate.javax.cache.provider",
                    "org.ehcache.jsr107.EhcacheCachingProvider");

            // FIX: Dynamically locate ehcache.xml from the classpath and get its true URI string
            URL ehcacheUrl = HibernateUtil.class.getClassLoader().getResource("ehcache.xml");
            if (ehcacheUrl != null) {
                cfg.setProperty("hibernate.javax.cache.uri", ehcacheUrl.toURI().toString());
            } else {
                throw new RuntimeException("ehcache.xml not found in classpath!");
            }

            // Enable Hibernate statistics.
            cfg.setProperty("hibernate.generate_statistics", "true");

            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(cfg.getProperties())
                            .build();

            sessionFactory = cfg.buildSessionFactory(registry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}