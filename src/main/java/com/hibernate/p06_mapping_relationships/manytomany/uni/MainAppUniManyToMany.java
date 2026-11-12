package com.hibernate.p06_mapping_relationships.manytomany.uni;


import com.hibernate.p06_mapping_relationships.manytomany.uni.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.manytomany.uni.entity.Employee;
import com.hibernate.p06_mapping_relationships.manytomany.uni.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainAppUniManyToMany {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            // ==========================================
            // 1. CREATE Operation
            // ==========================================
            tx = session.beginTransaction();

            Project proj1 = new Project("Cloud Migration");
            Project proj2 = new Project("AI Chatbot Integration");

            Employee emp = new Employee("Praveen Kushwaha", "praveen@example.com");
            
            // Assign projects to employee
            emp.addProject(proj1);
            emp.addProject(proj2);

            // Persisting Employee cascades to projects and populates the join table
            session.persist(emp);

            tx.commit();
            System.out.println("-> Unidirectional Many-to-Many saved successfully!");

            // ==========================================
            // 2. READ Operation (Forward Navigation Only)
            // ==========================================
            session.clear(); // Clear cache to force a fresh DB query

            Employee fetchedEmp = session.get(Employee.class, emp.getId());
            System.out.println("\n-> Employee Name: " + fetchedEmp.getName());
            System.out.println("-> Assigned Projects:");
            for (Project p : fetchedEmp.getProjects()) {
                System.out.println("   - " + p.getTitle());
            }

            /*
             * Note: You CANNOT query a Project and call getEmployees() 
             * because Project has no knowledge of or reference to Employee.
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