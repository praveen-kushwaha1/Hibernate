package com.hibernate.p07_embedded_inheritance.inheritance.tableperclass;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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


//CREATE TABLE tpc_permanent_employee (
//        id BIGINT PRIMARY KEY,
//        name VARCHAR(255),
//email VARCHAR(255),
//department VARCHAR(255),
//salary DOUBLE,
//bonus DOUBLE,
//pfNumber VARCHAR(255)
//);
//
//CREATE TABLE tpc_contract_employee (
//        id BIGINT PRIMARY KEY,
//        name VARCHAR(255),
//email VARCHAR(255),
//department VARCHAR(255),
//salary DOUBLE,
//contractDurationMonths INTEGER,
//agencyName VARCHAR(255)
//);Notice:
//- No common parent table.
//- No foreign key linking child tables.
//- Common fields are repeated in every concrete child table.
//- ID generation uses a sequence strategy to support IDs across the hierarchy.
//);
