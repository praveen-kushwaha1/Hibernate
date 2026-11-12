package com.hibernate.p06_mapping_relationships.manytomany.bi;


import com.hibernate.p06_mapping_relationships.manytomany.bi.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.manytomany.bi.entity.Employee;
import com.hibernate.p06_mapping_relationships.manytomany.bi.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyToManyApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            // ==========================================
            // 1. CREATE Operation
            // ==========================================
            tx = session.beginTransaction();

            // Create Projects
            Project proj1 = new Project("Cloud Migration");
            Project proj2 = new Project("AI Chatbot Integration");

            // Create Employees
            Employee emp1 = new Employee("Praveen Kushwaha", "praveen@example.com");
            Employee emp2 = new Employee("Amit Sharma", "amit@example.com");

            // Link Employees to Projects using helper methods
            emp1.addProject(proj1);
            emp1.addProject(proj2); // Praveen works on both projects

            emp2.addProject(proj1); // Amit works only on Cloud Migration

            // Persist through the owning side (Employee)
            session.persist(emp1);
            session.persist(emp2);

            tx.commit();
            System.out.println("-> Employees and Projects saved successfully with Many-to-Many mapping.");

            // ==========================================
            // 2. READ & NAVIGATE Operation
            // ==========================================
            session.clear(); // Clear cache to force a fresh database read

            // Fetch Employee and inspect their projects
            Employee fetchedEmp = session.find(Employee.class, emp1.getId());
            System.out.println("\n-> Employee: " + fetchedEmp.getName());
            System.out.println("-> Assigned Projects count: " + fetchedEmp.getProjects().size());
            for (Project p : fetchedEmp.getProjects()) {
                System.out.println("   - Project Title: " + p.getTitle());
            }

            // Fetch Project and inspect assigned employees (Reverse Navigation)
            Project fetchedProj = session.find(Project.class, proj1.getId());
            System.out.println("\n-> Project: " + fetchedProj.getTitle());
            System.out.println("-> Assigned Employees count: " + fetchedProj.getEmployees().size());
            for (Employee e : fetchedProj.getEmployees()) {
                System.out.println("   - Employee Name: " + e.getName());
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}