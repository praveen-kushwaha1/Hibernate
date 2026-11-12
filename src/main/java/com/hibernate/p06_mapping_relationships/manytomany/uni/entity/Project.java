package com.hibernate.p06_mapping_relationships.manytomany.uni.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects_m2m_uni")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_title")
    private String title;

    public Project() {}

    public Project(String title) {
        this.title = title;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}