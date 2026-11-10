package com.hibernate.p03_annotation_configuration.dao;


import com.hibernate.p03_annotation_configuration.config.HibernateUtil;
import com.hibernate.p03_annotation_configuration.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {

    // Create (Insert)
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(user); // Hibernate 6 prefers persist() over save()
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Read (Retrieve all)
    public List<User> getUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).getResultList(); // Hibernate 6 uses getResultList()
        }
    }

    // Read by ID (Optional)
    public User getUserById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(User.class, id); // Hibernate 6 uses find()
        }
    }

    // Update
    public void updateUser(Long id, String newName) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.find(User.class, id);
            if (user != null) {
                user.setName(newName);
                // No explicit update needed in Hibernate 6 if entity is managed
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.find(User.class, id);
            if (user != null) {
                session.remove(user); // Hibernate 6 replaces delete() with remove()
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

	// session.find() – JPA-compliant, eager fetch, returns null if not found
	// session.get() – Hibernate-specific, eager fetch, returns null if not found
	// session.load() – Hibernate-specific, lazy fetch, throws exception if entity
	// is missing
	// ✅ Use Lazy Loading (FetchType.LAZY) by default to optimize DB queries.
	// ✅ Use Eager Loading (FetchType.EAGER) only when related entities are always
	// required.
	// ✅ Avoid LazyInitializationException by handling lazy-loaded entities before
	// closing the session.

	/*
	 * Session session = HibernateUtil.getSessionFactory().openSession();
	 * 
	 * // Lazy Loading - Orders are loaded only when accessed
	 * 
	 * @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY) private List<Order>
	 * orders;
	 * 
	 * // Eager Loading - Orders are loaded immediately along with Customer
	 * 
	 * @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) private
	 * List<Order> eagerOrders;
	 * 
	 * // 1. Using get() → Immediately fetches data User user1 =
	 * session.get(User.class, 1L); // Retrieves actual object
	 * System.out.println("User: " + user1.getName()); // Works without issue
	 * 
	 * // 2. Using load() → Returns a proxy (lazy loading) User user2 =
	 * session.load(User.class, 2L); // Doesn't hit DB yet
	 * System.out.println("User ID: " + user2.getId()); // Works (ID is known)
	 * System.out.println("User Name: " + user2.getName()); // Hits DB NOW
	 * 
	 * // 3. Using find() → Similar to get() User user3 = session.find(User.class,
	 * 3L); // Works like get() System.out.println("User: " + user3.getName());
	 * 
	 * session.close();
	 * 
	 */
    
    
 // ===============================
 // Hibernate Persistence Methods
 // ===============================

 // save(): Saves a new entity and returns the generated ID (works outside transaction).
 // persist(): Saves an entity but requires an active transaction (does not return ID).
 // update(): Updates an existing entity that is already persistent (throws error if entity is detached).
 // merge(): Merges changes from a detached entity into an existing persistent entity (creates new if not exists).
 // delete(): Removes an entity from the database.


 // ===============================
 // Hibernate Fetch Methods
 // ===============================

 // get(): Fetches an entity immediately, returns null if not found.
 // load(): Returns a proxy and fetches data only when accessed (throws error if not found).
 // find(): Works similarly to get(), but is JPA-specific.


 // ===============================
 // Lazy vs Eager Loading
 // ===============================

 // Lazy Loading: Loads related entities only when accessed (better performance).
 // Eager Loading: Loads related entities immediately (avoids LazyInitializationException).


 // ===============================
 // Hibernate Transactions
 // ===============================

 // Always start transaction for insert, update, and delete operations.
 // session.beginTransaction(); // Start transaction
 // session.commit(); // Apply changes
 // session.rollback(); // Revert changes in case of failure
 // session.close(); // Close session


}
