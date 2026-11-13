package com.hibernate.p14_nplusone.demo;



import com.hibernate.p14_nplusone.entity.Department;
import com.hibernate.p14_nplusone.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NPlusOneProblemDemo {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            // Query 1: Fetch all departments.
            List<Department> departments =
                    session.createQuery(
                            "FROM Department",
                            Department.class
                    ).getResultList();

            // Access employees of each department.
            for (Department department : departments) {

                System.out.println(
                        "Department: " + department.getName()
                );

                // Additional SQL query may execute here.
                department.getEmployees().forEach(employee ->
                        System.out.println(employee.getName())
                );
            }

            transaction.commit();

        } finally {
            HibernateUtil.shutdown();
        }
    }
}