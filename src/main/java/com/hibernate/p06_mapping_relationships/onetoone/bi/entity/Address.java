package com.hibernate.p06_mapping_relationships.onetoone.bi.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    // Inverse side: 'address' matches the field name inside Employee.java
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Employee employee;

    public Address() {}

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}

//In a bidirectional one-to-one mapping:
//
//The Owning Side (Employee) still contains the foreign key column (address_id) and uses @JoinColumn.
//
// The Inverse/Non-Owning Side (Address) adds a reference back to Employee and uses the mappedBy attribute to tell Hibernate that it does not own the foreign key column.


//Key Rules to Remember for Bidirectional Mapping:
//mappedBy: Must be placed on the non-owning entity (Address), pointing to the exact Java field name (address) defined inside the owning entity (Employee).
//
//Foreign Key Placement: The database table for employees will still hold the address_id foreign key column because Employee is the owning side.
//
//        In-Memory Synchronization: Using helper methods (like setting address.setEmployee(this) inside Employee) prevents stale object states when working with objects inside the same running Java session before they are flushed or committed.