package com.hibernate.p07_embedded_inheritance.inheritance.singletable;

import jakarta.persistence.*;

@Entity
@Table(name = "single_employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type")
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

    public void setName(String name) {
        this.name = name;
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


//CREATE TABLE single_employee (
//        id BIGINT PRIMARY KEY,
//        employee_type VARCHAR(31),
//name VARCHAR(255),
//email VARCHAR(255),
//department VARCHAR(255),
//salary DOUBLE,
//bonus DOUBLE,
//pfNumber VARCHAR(255),
//contractDurationMonths INTEGER,
//agencyName VARCHAR(255),
//);
