package com.hibernate.p04_entity_lifecycle.lifecycle;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachedExample {

    public static void execute() {

        Long studentId;

        // STEP 1: Create and save student.
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = new Student(
                    "Amit",
                    "amit@gmail.com",
                    "Java"
            );

            session.persist(student);

            transaction.commit();

            studentId = student.getId();

            // At this point, student is still persistent
            // because it belongs to the open Session.
        }

        // STEP 2: Session is closed.
        // The student object is now DETACHED.

        Student detachedStudent;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            detachedStudent = session.find(Student.class, studentId);
        }

        // Session is closed, so detachedStudent is detached.
        // This modification does not automatically update the DB.
        detachedStudent.setCourse("Microservices");

        System.out.println("Detached Student: " + detachedStudent);
    }
}