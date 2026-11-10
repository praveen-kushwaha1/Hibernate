package com.hibernate.p05_identifier_generation.embeddedid.dao;


import com.hibernate.p05_identifier_generation.common.GenericDao;
import com.hibernate.p05_identifier_generation.embeddedid.entity.Employee;
import com.hibernate.p05_identifier_generation.embeddedid.key.EmployeeId;

public class EmployeeDao extends GenericDao<Employee, EmployeeId> {

    public EmployeeDao() {
        super(Employee.class);
    }
}