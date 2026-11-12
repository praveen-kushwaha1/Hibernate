package com.hibernate.p06_mapping_relationships.onetomany.uni;


import com.hibernate.p06_mapping_relationships.onetomany.uni.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.onetomany.uni.entity.Department;
import com.hibernate.p06_mapping_relationships.onetomany.uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainAppUni {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            // ==========================================
            // 1. CREATE Operation
            // ==========================================
            tx = session.beginTransaction();

            Department dept = new Department("Engineering");

            // Employee references Department.
            // Because of CascadeType.ALL on employee.department, saving employee saves department too.
            Employee emp1 = new Employee("Praveen Kushwaha", "praveen@example.com", dept);
            Employee emp2 = new Employee("Amit Sharma", "amit@example.com", dept);

            session.persist(emp1);
            session.persist(emp2);

            tx.commit();
            System.out.println("-> Employees and Department saved successfully.");

            // ==========================================
            // 2. READ Operation (Navigate Employee -> Department)
            // ==========================================
            session.clear(); // Clear cache to force a fresh DB query

            Employee fetchedEmp = session.find(Employee.class, emp1.getId());
            System.out.println("-> Employee Name: " + fetchedEmp.getName());
            System.out.println("-> Department Name: " + fetchedEmp.getDepartment().getName());

            /*
             * Note: You CANNOT do fetchedDept.getEmployees() here because
             * Department does not have a reference or mapping back to Employee.
             */

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}