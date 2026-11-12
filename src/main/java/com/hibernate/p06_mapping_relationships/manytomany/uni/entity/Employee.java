package com.hibernate.p06_mapping_relationships.manytomany.uni.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees_m2m_uni")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "email")
    private String email;

    // Owning side defines the Join Table. Project has no idea this mapping exists.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "employee_project_uni_mapping", // Intermediary join table
            joinColumns = @JoinColumn(name = "employee_id"), // FK pointing to Employee
            inverseJoinColumns = @JoinColumn(name = "project_id") // FK pointing to Project
    )
    private List<Project> projects = new ArrayList<>();

    public Employee() {}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Helper method to add projects easily
    public void addProject(Project project) {
        projects.add(project);
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}