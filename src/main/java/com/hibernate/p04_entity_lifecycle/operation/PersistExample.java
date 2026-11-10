package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Create a transient entity.
            Student student = new Student(
                    "Praveen",
                    "persist@gmail.com",
                    "Hibernate"
            );

            // TRANSIENT -> PERSISTENT
            session.persist(student);

            // Hibernate tracks student from this point.
            // Its INSERT is synchronized during flush.
            transaction.commit();

            System.out.println("Saved Student ID: " + student.getId());

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}