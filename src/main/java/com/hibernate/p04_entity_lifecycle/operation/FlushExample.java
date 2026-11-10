package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FlushExample {

    public static void execute() {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Student student = new Student(
                    "Amit",
                    "flush@gmail.com",
                    "Java"
            );

            session.persist(student);

            // Hibernate synchronizes pending changes with DB.
            session.flush();

            System.out.println("INSERT synchronized with database.");

            // Modify managed entity.
            student.setCourse("Spring Boot");

            // Synchronize UPDATE with database.
            session.flush();

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            exception.printStackTrace();
        }
    }
}