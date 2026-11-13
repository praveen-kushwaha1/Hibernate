package com.hibernate.p14_nplusone.demo;

import com.hibernate.p14_nplusone.entity.Department;
import com.hibernate.p14_nplusone.util.HibernateUtil;

import org.hibernate.Session;

import java.util.List;

public class JoinFetchSolutionDemo {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            // Fetch departments and employees together.
            List<Department> departments =
                    session.createQuery(
                            "SELECT DISTINCT d " +
                            "FROM Department d " +
                            "LEFT JOIN FETCH d.employees",
                            Department.class
                    ).getResultList();

            for (Department department : departments) {

                System.out.println(
                        "Department: " + department.getName()
                );

                department.getEmployees().forEach(employee ->
                        System.out.println(employee.getName())
                );
            }
        } finally {
            HibernateUtil.shutdown();
        }
    }
}