package com.hibernate.p04_entity_lifecycle;



import com.hibernate.p04_entity_lifecycle.config.HibernateUtil;
import com.hibernate.p04_entity_lifecycle.entity.Student;
import com.hibernate.p04_entity_lifecycle.lifecycle.DetachedExample;
import com.hibernate.p04_entity_lifecycle.lifecycle.PersistentExample;
import com.hibernate.p04_entity_lifecycle.lifecycle.RemovedExample;
import com.hibernate.p04_entity_lifecycle.lifecycle.TransientExample;
import com.hibernate.p04_entity_lifecycle.operation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateApplication {

    public static void main(String[] args) {

        try {

            System.out.println("\n========== ENTITY LIFECYCLE ==========");

            // 1. Transient state
            TransientExample.execute();

            // 2. Persistent state
            PersistentExample.execute();

            // 3. Detached state
            DetachedExample.execute();

            // 4. Removed state
            RemovedExample.execute();


            System.out.println("\n========== HIBERNATE OPERATIONS ==========");

            // 5. Persist operation
            PersistExample.execute();

            // 6. Merge operation
            MergeExample.execute();

            // 7. Refresh operation
            Long refreshStudentId = createRefreshStudent();
            RefreshExample.execute(refreshStudentId);

            // 8. Flush operation
            FlushExample.execute();

            // 9. Clear operation
            ClearExample.execute();

            // 10. Evict operation
            EvictExample.execute();

            // 11. Remove operation
            Long removeStudentId = createRemoveStudent();
            RemoveExample.execute(removeStudentId);

            System.out.println("\nAll examples executed.");

        } finally {

            // Close SessionFactory after all examples finish.
            HibernateUtil.shutdown();
        }
    }

    private static Long createRefreshStudent() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = new Student(
                    "Refresh User",
                    "refresh-user@gmail.com",
                    "Java"
            );

            session.persist(student);

            transaction.commit();

            return student.getId();
        }
    }

    private static Long createRemoveStudent() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = new Student(
                    "Remove User",
                    "remove-user@gmail.com",
                    "Hibernate"
            );

            session.persist(student);

            transaction.commit();

            return student.getId();
        }
    }
}