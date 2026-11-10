package com.hibernate.p04_entity_lifecycle.lifecycle;


import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistentExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Create a transient object.
            Student student = new Student(
                    "Rahul",
                    "rahul@gmail.com",
                    "Java"
            );

            // Associate object with Hibernate Session.
            // Entity becomes PERSISTENT.
            session.persist(student);

            // Hibernate now tracks this object.
            student.setCourse("Spring Boot");

            // No explicit update() call is required.
            // Hibernate detects the changed property using dirty checking.

            transaction.commit();

            System.out.println("Persistent Student: " + student);

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}