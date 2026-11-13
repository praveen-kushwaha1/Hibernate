package com.hibernate.p07_embedded_inheritance.inheritance.joined;

import jakarta.persistence.*;

@Entity
@Table(name = "joined_employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String email,
                    String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}


//CREATE TABLE joined_employee (
//        id BIGINT PRIMARY KEY,
//        name VARCHAR(255),
//email VARCHAR(255),
//department VARCHAR(255),
//salary DOUBLE
//);
//
//CREATE TABLE joined_permanent_employee (
//        id BIGINT PRIMARY KEY,
//        bonus DOUBLE,
//        pfNumber VARCHAR(255),
//FOREIGN KEY (id) REFERENCES joined_employee(id)
//        );
//
//CREATE TABLE joined_contract_employee (
//        id BIGINT PRIMARY KEY,
//        contractDurationMonths INTEGER,
//        agencyName VARCHAR(255),
//FOREIGN KEY (id) REFERENCES joined_employee(id)
//        );
//
//        );
