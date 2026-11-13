package com.hibernate.p14_nplusone.util;






import com.hibernate.p14_nplusone.entity.Department;
import com.hibernate.p14_nplusone.entity.Employee;
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
        // SQL formatting & logging properties
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");          // Formats SQL nicely
        cfg.setProperty("hibernate.highlight_sql", "true");       // Adds color/formatting if your console supports ANSI

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
