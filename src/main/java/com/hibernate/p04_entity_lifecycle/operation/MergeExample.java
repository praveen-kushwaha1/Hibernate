package com.hibernate.p04_entity_lifecycle.operation;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MergeExample {

    public static void execute() {

        Long studentId;

        // STEP 1: Create a student.
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = new Student(
                    "Rahul",
                    "merge@gmail.com",
                    "Java"
            );

            session.persist(student);

            transaction.commit();

            studentId = student.getId();
        }

        // STEP 2: Load entity and close Session.
        Student detachedStudent;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            detachedStudent = session.find(Student.class, studentId);
        }

        // Entity is detached now.
        detachedStudent.setCourse("Spring Boot");

        // STEP 3: Merge detached entity.
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            // Copies detachedStudent state into a managed instance.
            Student managedStudent =
                    (Student) session.merge(detachedStudent);

            // Important:
            // detachedStudent is STILL detached.
            // managedStudent is the persistent object.

            managedStudent.setName("Rahul Kumar");

            transaction.commit();

            System.out.println("Merged Student: " + managedStudent);
        }
    }
}