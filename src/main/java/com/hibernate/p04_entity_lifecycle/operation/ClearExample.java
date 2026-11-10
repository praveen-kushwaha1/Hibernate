package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClearExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Student student1 = new Student(
                    "Rahul",
                    "clear1@gmail.com",
                    "Java"
            );

            Student student2 = new Student(
                    "Amit",
                    "clear2@gmail.com",
                    "Hibernate"
            );

            session.persist(student1);
            session.persist(student2);

            // Both objects are currently persistent.

            // Detaches ALL managed entities from this Session.
            session.clear();

            // Both objects are now detached.
            student1.setCourse("Spring Boot");

            // This change will NOT be automatically tracked.
            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}