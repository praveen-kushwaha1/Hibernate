package com.hibernate.p07_embedded_inheritance.embedded.elementcollection;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee owns a collection of simple String values.
 */
@Entity
@Table(name = "collection_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    /**
     * Stores skills in a separate collection table.
     *Real-world example
     * An Employee has multiple skills:
     * - Java
     * - Spring Boot
     * - Hibernate
     * - Microservices
     * Are these skills entities?
     *
     * No. For this example, we consider skills simple values rather than independently managed entities.
     * No Skill entity is required.
     */
    @ElementCollection
    @CollectionTable(
        name = "employee_skills",
        joinColumns = @JoinColumn(name = "employee_id")
    )
    @Column(name = "skill")
    private List<String> skills = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}