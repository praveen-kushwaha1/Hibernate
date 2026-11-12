package com.hibernate.p06_mapping_relationships.onetoone.bi;



import com.hibernate.p06_mapping_relationships.onetoone.bi.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.onetoone.bi.entity.Address;
import com.hibernate.p06_mapping_relationships.onetoone.bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // ==========================================
            // 1. CREATE Operation
            // ==========================================
            transaction = session.beginTransaction();

            Address address = new Address("456 MG Road", "Bangalore", "Karnataka", "560001");
            Employee employee = new Employee("Praveen Kushwaha", "praveen@example.com", address);

            session.persist(employee); // Saves both Employee and Address
            transaction.commit();
            System.out.println("-> Employee created with ID: " + employee.getId());

            // ==========================================
            // 2. READ & NAVIGATE BOTH WAYS
            // ==========================================
            session.clear(); // Clear cache to force a fresh database read

            // Fetching Employee -> Address
            Employee fetchedEmployee = session.find(Employee.class, employee.getId());
            System.out.println("-> Employee Name: " + fetchedEmployee.getName());
            System.out.println("-> Associated Address City: " + fetchedEmployee.getAddress().getCity());

            // Fetching Address -> Employee (Proves Bidirectional Navigation works)
            Address fetchedAddress = session.find(Address.class, address.getId());
            System.out.println("-> Address City: " + fetchedAddress.getCity());
            System.out.println("-> Owner Employee Name: " + fetchedAddress.getEmployee().getName());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}