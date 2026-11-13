package com.hibernate.p08_querys.p03_criteriaapi.dto;

import java.math.BigDecimal;

public class EmployeeDTO {

    private String name;
    private BigDecimal salary;
    private String departmentName;

    public EmployeeDTO(String name,
                       BigDecimal salary,
                       String departmentName) {

        this.name = name;
        this.salary = salary;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
