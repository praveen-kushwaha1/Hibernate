package com.hibernate.p07_embedded_inheritance.embedded.embeddable;


import com.hibernate.p07_embedded_inheritance.embedded.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmbeddableDemo {

    public static void main(String[] args) {

        // CREATE
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            Address address = new Address(
                    "MG Road",
                    "Bengaluru",
                    "Karnataka",
                    "560001"
            );

            Employee employee =
                    new Employee("Praveen", 50000, address);

            session.persist(employee);

            tx.commit();

            System.out.println("Employee saved: " + employee.getId());
        }

        // READ
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Employee employee =
                    session.find(Employee.class, 1L);

            if (employee != null) {
                System.out.println(employee.getName());
                System.out.println(employee.getAddress().getCity());
            }
        }

        // UPDATE
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            Employee employee =
                    session.find(Employee.class, 1L);

            if (employee != null) {

                employee.setSalary(60000);

                employee.getAddress().setCity("Noida");

                // Hibernate detects changes and updates the database.
            }

            tx.commit();
        }

        // DELETE
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            Employee employee =
                    session.find(Employee.class, 1L);

            if (employee != null) {
                session.remove(employee);
            }

            tx.commit();
        }
    }
}