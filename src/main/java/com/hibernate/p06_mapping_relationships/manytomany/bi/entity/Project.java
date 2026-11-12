package com.hibernate.p06_mapping_relationships.manytomany.bi.entity;

import com.hibernate.p06_mapping_relationships.manytomany.bi.entity.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects_m2m")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_title")
    private String title;

    // Inverse side: 'projects' matches the field name inside Employee.java
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();

    public Project() {}

    public Project(String title) {
        this.title = title;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}