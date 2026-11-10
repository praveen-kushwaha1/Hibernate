package com.hibernate.p04_entity_lifecycle.lifecycle;


import com.hibernate.p04_entity_lifecycle.entity.Student;

public class TransientExample {

    public static void execute() {

        // Creating a normal Java object.
        // It is currently in the TRANSIENT state.
        Student student = new Student(
                "Praveen",
                "praveen@gmail.com",
                "Java"
        );

        // This object is not associated with any Hibernate Session.
        // Changing its properties does not generate SQL.
        student.setCourse("Spring Boot");

        System.out.println("Transient Student: " + student);

        // No INSERT query will execute here.
    }
}