package com.hibernate.p14_nplusone.demo;



import jakarta.persistence.EntityGraph;

import org.hibernate.Session;

import java.util.List;
import com.hibernate.p14_nplusone.entity.Department;
import com.hibernate.p14_nplusone.util.HibernateUtil;

public class EntityGraphSolutionDemo {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            // Create a fetch graph for Department.
            EntityGraph<Department> graph =
                    session.createEntityGraph(Department.class);

            // Include employees in the fetch plan.
            graph.addAttributeNodes("employees");

            // Fetch departments using the entity graph.
            List<Department> departments =
                    session.createQuery(
                            "FROM Department",
                            Department.class
                    )
                    .setHint("jakarta.persistence.fetchgraph", graph)
                    .getResultList();

            for (Department department : departments) {

                System.out.println(department.getName());

                department.getEmployees().forEach(employee ->
                        System.out.println(employee.getName())
                );
            }
        } finally {
            HibernateUtil.shutdown();
        }
    }
}