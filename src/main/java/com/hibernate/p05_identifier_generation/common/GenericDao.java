package com.hibernate.p05_identifier_generation.common;


import com.hibernate.p05_identifier_generation.zconfig.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenericDao<T, ID> {

    private final Class<T> entityClass;

    // Constructor receives the entity type.
    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // CREATE: Saves a new entity in the database.
    public void save(T entity) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(entity);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Error while saving entity", e);
        }
    }

    // READ: Finds an entity using its primary key.
    public T findById(ID id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.find(entityClass, id);
        }
    }

    // READ ALL: Retrieves all records of the entity.
    public List<T> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM " + entityClass.getSimpleName();

            return session.createQuery(hql, entityClass).list();
        }
    }

    // UPDATE: Merges detached entity state into the current session.
    public T update(T entity) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            T updatedEntity = session.merge(entity);

            transaction.commit();

            return updatedEntity;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Error while updating entity", e);
        }
    }

    // DELETE: Finds the record and removes it.
    public void delete(ID id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            T entity = session.find(entityClass, id);

            if (entity != null) {
                session.remove(entity);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Error while deleting entity", e);
        }
    }
}
