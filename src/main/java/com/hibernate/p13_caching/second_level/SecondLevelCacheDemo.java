
package com.hibernate.p13_caching.second_level;

import com.hibernate.p13_caching.second_level.entity.Employee;
import com.hibernate.p13_caching.second_level.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

public class SecondLevelCacheDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        // Get Hibernate cache statistics.
        Statistics statistics = sessionFactory.getStatistics();

        statistics.clear();

//        Session session = sessionFactory.openSession();
//        Transaction transaction1 = session.beginTransaction();
//        session.persist(new Employee("Praveen", "Kushwaha", 4547554));
//        transaction1.commit();

        try {

            // SESSION 1
            System.out.println("===== SESSION 1 =====");

            try (Session session1 = sessionFactory.openSession()) {

                Transaction transaction = session1.beginTransaction();

                // First fetch: Database query if cache is empty.
                Employee employee1 =
                        session1.get(Employee.class, 1L);

                System.out.println(employee1);

                transaction.commit();
            }

            // SESSION 1 CLOSED.
            // First-level cache is no longer available.

            // SESSION 2
            System.out.println("===== SESSION 2 =====");

            try (Session session2 = sessionFactory.openSession()) {

                Transaction transaction = session2.beginTransaction();

                // Second fetch: Should come from L2 cache.
                Employee employee2 =
                        session2.get(Employee.class, 1L);

                System.out.println(employee2);

                transaction.commit();
            }

            // Display cache statistics.
            System.out.println("===== CACHE STATISTICS =====");

            System.out.println(
                    "L2 Cache Hit Count: " +
                    statistics.getSecondLevelCacheHitCount()
            );

            System.out.println(
                    "L2 Cache Miss Count: " +
                    statistics.getSecondLevelCacheMissCount()
            );

            System.out.println(
                    "L2 Cache Put Count: " +
                    statistics.getSecondLevelCachePutCount()
            );

        } finally {

            HibernateUtil.shutdown();
        }
    }
}
