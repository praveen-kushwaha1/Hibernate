package com.hibernate.p06_mapping_relationships.onetoone.uni;



import com.hibernate.p06_mapping_relationships.onetoone.uni.config.HibernateUtil;
import com.hibernate.p06_mapping_relationships.onetoone.uni.entity.Address;
import com.hibernate.p06_mapping_relationships.onetoone.uni.entity.Employee;
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
            session.persist(employee); // Saves both Employee and Address due to CascadeType.ALL
            transaction.commit();
            System.out.println("-> Employee created successfully with ID: " + employee.getId());

            // ==========================================
            // 2. READ Operation
            // ==========================================
            session.clear(); // Clear cache to force database read
            Employee fetchedEmployee = session.find(Employee.class, employee.getId());
            System.out.println("-> Read Employee: " + fetchedEmployee.getName());
            System.out.println("-> Read Address City: " + fetchedEmployee.getAddress().getCity());

            // ==========================================
            // 3. UPDATE Operation
            // ==========================================
            transaction = session.beginTransaction();
            fetchedEmployee.getAddress().setCity("Mysore"); // Modify nested property
            session.merge(fetchedEmployee);
            transaction.commit();
            System.out.println("-> Updated Address City to: " + fetchedEmployee.getAddress().getCity());

            // ==========================================
            // 4. DELETE Operation
            // ==========================================
            /*
            transaction = session.beginTransaction();
            session.remove(fetchedEmployee); // Cascades delete to the associated Address
            transaction.commit();
            System.out.println("-> Employee and Address deleted successfully.");
            */

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
//
//Key Takeaways for Unidirectional Mapping:
//@JoinColumn: Placed on the owning side (Employee) to define the foreign key column (address_id) pointing to the target entity (Address).
//
//CascadeType.ALL: Ensures that operations like persist, merge, and remove performed on Employee automatically cascade to the associated Address.
//
//        orphanRemoval = true: Automatically deletes the Address record from the database if it gets unlinked or detached from the Employee.