package com.hibernate.p02_xml_configuration.dao;


import com.hibernate.p02_xml_configuration.entity.User;
import com.hibernate.p02_xml_configuration.config.HibernateUtil;
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
}
