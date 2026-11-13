package com.hibernate.p07_embedded_inheritance.embedded.embeddable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Employee owns the Address value object.
 */
@Entity
@Table(name = "embedded_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double salary;

    /**
     * @Embedded tells Hibernate to store Address fields
     * directly in embedded_employee table.
     */
    @Embedded
    private Address address;

    public Employee() {
    }

    public Employee(String name, double salary, Address address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

//Notice: There is no address table.
//        Interview notes
//Annotation	Meaning
//@Embeddable	Defines a value object
//@Embedded	Embeds the value object into an entity
//@Entity	Defines an entity with identity
//@Id	Defines the primary key
//
//Key takeaway:
//
//@Embeddable is the reusable class. @Embedded is the place where it is used.