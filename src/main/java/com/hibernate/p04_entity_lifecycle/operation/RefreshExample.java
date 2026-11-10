package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RefreshExample {

    public static void execute(Long studentId) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Load student from database.
            Student student = session.find(Student.class, studentId);

            System.out.println("Before modification: " + student);

            // Change only the in-memory Java object.
            student.setCourse("Temporary Course");

            System.out.println("Before refresh: " + student);

            // Reload database state.
            // In-memory changes are overwritten.
            session.refresh(student);

            System.out.println("After refresh: " + student);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}