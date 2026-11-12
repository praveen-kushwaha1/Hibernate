package com.hibernate.p06_mapping_relationships.onetoone.uni.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Unidirectional One-to-One Mapping using native Hibernate cascade behavior
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Employee() {}

    public Employee(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}

//Key Takeaways for Unidirectional Mapping:
//@JoinColumn: Placed on the owning side (Employee) to define the foreign key column (address_id) pointing to the target entity (Address).
//
//CascadeType.ALL: Ensures that operations like persist, merge, and remove performed on Employee automatically cascade to the associated Address.
//
//        orphanRemoval = true: Automatically deletes the Address record from the database if it gets unlinked or detached from the Employee.