package com.hibernate.p05_identifier_generation.embeddedid.entity;



import com.hibernate.p05_identifier_generation.embeddedid.key.EmployeeId;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    // Both employeeId and departmentId form the primary key.
    @EmbeddedId
    private EmployeeId id;

    private String name;

    private String email;

    public Employee() {
    }

    public Employee(EmployeeId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
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
}
