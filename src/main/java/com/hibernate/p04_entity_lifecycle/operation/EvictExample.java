package com.hibernate.p04_entity_lifecycle.operation;


import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EvictExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Student student1 = new Student(
                    "Rahul",
                    "evict1@gmail.com",
                    "Java"
            );

            Student student2 = new Student(
                    "Amit",
                    "evict2@gmail.com",
                    "Hibernate"
            );

            session.persist(student1);
            session.persist(student2);

            // Both entities are persistent.

            // Detach only student1.
            session.evict(student1);

            // student1 is detached.
            // student2 is still persistent.

            student1.setCourse("Spring Boot");

            // This change is not tracked.
            student2.setCourse("Spring Framework");

            // Hibernate updates student2, but not student1.
            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}