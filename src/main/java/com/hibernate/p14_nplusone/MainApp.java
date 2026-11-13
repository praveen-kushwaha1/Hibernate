package com.hibernate.p14_nplusone;



import com.hibernate.p14_nplusone.entity.Department;
import com.hibernate.p14_nplusone.entity.Employee;
import com.hibernate.p14_nplusone.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Department 1
            Department it = new Department("IT");
            it.addEmployee(new Employee("Rahul", 50000));
            it.addEmployee(new Employee("Amit", 60000));
            it.addEmployee(new Employee("Priya", 55000));

            // Department 2
            Department hr = new Department("HR");
            hr.addEmployee(new Employee("Neha", 45000));
            hr.addEmployee(new Employee("Raj", 40000));

            // Department 3
            Department finance = new Department("Finance");
            finance.addEmployee(new Employee("Vikas", 65000));
            finance.addEmployee(new Employee("Aman", 50000));

            session.persist(it);
            session.persist(hr);
            session.persist(finance);

            transaction.commit();

            System.out.println("Sample data inserted!");

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {
            HibernateUtil.shutdown();
        }
    }
}