package com.hibernate.p05_identifier_generation.sequence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sequence_students")
public class SequenceStudent {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence_generator"
    )
    @SequenceGenerator(
            name = "student_sequence_generator",
            sequenceName = "student_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String email;

    public SequenceStudent() {
    }

    public SequenceStudent(String name, String email) {
        this.name = name;
        this.email = email;
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
}
