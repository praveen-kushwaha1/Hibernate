package com.hibernate.p13_caching.first_level;

import com.hibernate.p13_caching.first_level.entity.Employee;
import com.hibernate.p13_caching.first_level.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        try {

            // STEP 1: Fetch employee for the first time.
            System.out.println("First Fetch:");

//            Employee employee = new Employee("Praveen", "Kushwaha", 4547554);
//            session.persist(employee);

            Employee employee1 =
                    session.find(Employee.class, 1L);

            System.out.println(employee1);


            // STEP 2: Fetch the same employee again.
            System.out.println("Second Fetch:");

            Employee employee2 =
                    session.find(Employee.class, 1L);

            System.out.println(employee2);


            // STEP 3: Compare object references.
            System.out.println(
                    "Same Object: " + (employee1 == employee2)
            );


            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {

            session.close();
            HibernateUtil.shutdown();
        }
    }
}