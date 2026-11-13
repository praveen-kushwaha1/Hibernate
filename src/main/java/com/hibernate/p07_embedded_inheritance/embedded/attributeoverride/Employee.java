package com.hibernate.p07_embedded_inheritance.embedded.attributeoverride;

import jakarta.persistence.*;

@Entity
@Table(name = "override_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Reuse Address but customize column names.
     */
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name = "street",
            column = @Column(name = "employee_street")
        ),
        @AttributeOverride(
            name = "city",
            column = @Column(name = "employee_city")
        ),
        @AttributeOverride(
            name = "state",
            column = @Column(name = "employee_state")
        )
    })
    private Address address;

    public Employee() {
    }

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
//CREATE TABLE override_employee (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(255),
//employee_street VARCHAR(255),
//employee_city VARCHAR(255),
//employee_state VARCHAR(255)
//);