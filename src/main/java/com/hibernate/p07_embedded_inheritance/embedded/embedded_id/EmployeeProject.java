package com.hibernate.p07_embedded_inheritance.embedded.embedded_id;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * EmployeeProject uses a composite primary key.
 */
@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @EmbeddedId
    private EmployeeProjectId id;

    private String projectName;

    private String role;

    public EmployeeProject() {
    }

    public EmployeeProject(EmployeeProjectId id,
                          String projectName,
                          String role) {

        this.id = id;
        this.projectName = projectName;
        this.role = role;
    }

    public EmployeeProjectId getId() {
        return id;
    }

    public void setId(EmployeeProjectId id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}