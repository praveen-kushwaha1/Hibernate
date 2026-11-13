package com.hibernate.p07_embedded_inheritance.inheritance.mappedsuperclass;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEmployee {

    // Primary key inherited by child entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Common employee properties
    private String name;
    private String email;
    private String department;
    private double salary;

    // Constructor
    public BaseEmployee() {
    }

    public BaseEmployee(String name, String email,
                        String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
