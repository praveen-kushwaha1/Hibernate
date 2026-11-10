package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemoveExample {

    public static void execute(Long studentId) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Load entity. It becomes persistent.
            Student student = session.find(Student.class, studentId);

            if (student != null) {

                // Persistent -> Removed
                session.remove(student);

                // DELETE will be synchronized during flush.
                System.out.println("Student marked for removal.");
            }

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}