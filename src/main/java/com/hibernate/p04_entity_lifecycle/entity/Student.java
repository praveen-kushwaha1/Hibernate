package com.hibernate.p04_entity_lifecycle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    // Primary key generated automatically by MySQL.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student name column.
    @Column(name = "student_name", nullable = false)
    private String name;

    // Student email must be unique.
    @Column(nullable = false, unique = true)
    private String email;

    // Student course.
    @Column(nullable = false)
    private String course;

    // Hibernate requires a no-argument constructor.
    public Student() {
    }

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
