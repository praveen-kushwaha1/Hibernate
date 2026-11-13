package com.hibernate.p07_embedded_inheritance.embedded.embedded_id;

import com.hibernate.p07_embedded_inheritance.embedded.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        // CREATE
        EmployeeProjectId id =
                new EmployeeProjectId(101L, 501L);

        EmployeeProject assignment =
                new EmployeeProject(id, "CurrencyX", "Backend Developer");

        session.persist(assignment);

// READ
        EmployeeProject result =
                session.find(EmployeeProject.class, id);

// UPDATE
        Transaction tx = session.beginTransaction();

        EmployeeProject existing =
                session.find(EmployeeProject.class, id);

        if (existing != null) {
            existing.setRole("Senior Backend Developer");
        }

        tx.commit();

// DELETE
        Transaction deleteTx = session.beginTransaction();

        EmployeeProject existingForDelete =
                session.find(EmployeeProject.class, id);

        if (existingForDelete != null) {
            session.remove(existingForDelete);
        }

        deleteTx.commit();

    }
}
