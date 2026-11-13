package com.hibernate.p07_embedded_inheritance.inheritance.dao;


import com.hibernate.p07_embedded_inheritance.inheritance.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {

    // CREATE
    public void save(Object employee) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(employee);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ
    public <T> T findById(Class<T> entityClass, Long id) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.find(entityClass, id);
        }
    }

    // UPDATE
    public void update(Object employee) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(employee);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public <T> void delete(Class<T> entityClass, Long id) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            T employee = session.find(entityClass, id);

            if (employee != null) {
                session.remove(employee);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
