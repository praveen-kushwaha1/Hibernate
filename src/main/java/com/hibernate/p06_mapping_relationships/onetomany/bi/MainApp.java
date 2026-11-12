package com.hibernate.p06_mapping_relationships.onetomany.bi;


import com.hibernate.p06_mapping_relationships.onetomany.bi.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.onetomany.bi.entity.Department;
import com.hibernate.p06_mapping_relationships.onetomany.bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            // ==========================================
            // 1. CREATE Operation (Cascaded Insert)
            // ==========================================
            tx = session.beginTransaction();

            Department dept = new Department("Engineering");

            Employee emp1 = new Employee("Praveen Kushwaha", "praveen@example.com");
            Employee emp2 = new Employee("Amit Sharma", "amit@example.com");

            // Use helper method to maintain bidirectional consistency in memory
            dept.addEmployee(emp1);
            dept.addEmployee(emp2);

            session.persist(dept); // CascadeType.ALL will automatically save employees as well
            tx.commit();
            System.out.println("-> Department saved with ID: " + dept.getId());

            // ==========================================
            // 2. READ & NAVIGATE Operation
            // ==========================================
            session.clear(); // Clear cache to force database query

            // Navigate from Department -> Employees (One-to-Many)
            Department fetchedDept = session.find(Department.class, dept.getId());
            System.out.println("-> Department: " + fetchedDept.getName());
            System.out.println("-> Total Employees: " + fetchedDept.getEmployees().size());
            for (Employee e : fetchedDept.getEmployees()) {
                System.out.println("   - Employee Name: " + e.getName());
            }

            // Navigate from Employee -> Department (Many-to-One)
            Employee fetchedEmp = session.find(Employee.class, emp1.getId());
            System.out.println("-> Fetched Employee: " + fetchedEmp.getName());
            System.out.println("-> Belongs to Department: " + fetchedEmp.getDepartment().getName());

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}