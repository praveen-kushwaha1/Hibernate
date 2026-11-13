package com.hibernate.p07_embedded_inheritance.embedded.embedded_id;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Composite primary key.
 *
 * Both employeeId and projectId together identify an assignment.
 */
@Embeddable
public class EmployeeProjectId implements Serializable {

    private Long employeeId;

    private Long projectId;

    public EmployeeProjectId() {
    }

    public EmployeeProjectId(Long employeeId, Long projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * Composite IDs must implement equals and hashCode.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmployeeProjectId other)) {
            return false;
        }

        return Objects.equals(employeeId, other.employeeId)
                && Objects.equals(projectId, other.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId);
    }
}
//Important interview points
//- @EmbeddedId defines a composite primary key.
//- The key class must be @Embeddable.
//- It should implement Serializable.
//        - It must implement equals() and hashCode().
//        - @EmbeddedId and @IdClass are two different ways to implement composite keys.