package com.hibernate.p05_identifier_generation.embeddedid.key;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeId implements Serializable {

    private Long employeeId;

    private Long departmentId;

    public EmployeeId() {
    }

    public EmployeeId(Long employeeId, Long departmentId) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    // Composite key must implement equals and hashCode.
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmployeeId)) {
            return false;
        }

        EmployeeId other = (EmployeeId) obj;

        return Objects.equals(employeeId, other.employeeId)
                && Objects.equals(departmentId, other.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, departmentId);
    }
}
