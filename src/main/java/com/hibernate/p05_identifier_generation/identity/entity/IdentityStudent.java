package com.hibernate.p05_identifier_generation.identity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "identity_students")
public class IdentityStudent {

    // Database generates the ID automatically.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public IdentityStudent() {
    }

    public IdentityStudent(String name, String email) {
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
