package com.hibernate.p04_entity_lifecycle.lifecycle;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // First, create a student.
            Student student = new Student(
                    "Vikas",
                    "vikas@gmail.com",
                    "Java"
            );

            session.persist(student);

            // Entity is now persistent.
            System.out.println("Before remove: " + student);

            // Mark entity for deletion.
            session.remove(student);

            // Entity is now in REMOVED state.
            // Hibernate will synchronize the DELETE at flush.
            transaction.commit();

            System.out.println("Student removed successfully.");

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}