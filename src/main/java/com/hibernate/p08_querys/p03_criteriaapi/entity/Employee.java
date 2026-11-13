package com.hibernate.p08_querys.p03_criteriaapi.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employeescriteria")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String city;

    private BigDecimal salary;

    private String designation;

    private LocalDate joiningDate;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, String city,
                    BigDecimal salary, String designation,
                    LocalDate joiningDate, boolean active,
                    Department department) {

        this.name = name;
        this.email = email;
        this.city = city;
        this.salary = salary;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.active = active;
        this.department = department;
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

    public String getCity() {
        return city;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public boolean isActive() {
        return active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
