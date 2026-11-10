# Hibernate Session vs SessionFactory

## 1. What is SessionFactory?

`SessionFactory` is a heavyweight, thread-safe Hibernate object responsible for creating `Session` objects.

It is usually created once during application startup and reused throughout the application's lifecycle.

### Responsibilities
- Creates Session instances.
- Reads Hibernate configuration.
- Stores entity mapping metadata.
- Manages integration with connection pools.
- Provides a factory for database operations.

### Example

```java
SessionFactory sessionFactory =
        new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
```

## 2. What is Session?

`Session` is a lightweight, non-thread-safe Hibernate object used to interact with the database.

It represents a persistence context and manages entity objects during a unit of work.

### Responsibilities
- Save entities.
- Retrieve entities.
- Update entities.
- Delete entities.
- Manage entity lifecycle.
- Perform dirty checking.
- Maintain the first-level cache.

### Example

```java
Session session = sessionFactory.openSession();
```

## 3. Architecture

```text
                 Hibernate Application
                         |
                         v
                  SessionFactory
                 (One per DB)
                         |
            -------------------------
            |           |           |
            v           v           v
         Session 1   Session 2   Session 3
            |           |           |
            v           v           v
        Transaction Transaction Transaction
            |           |           |
            v           v           v
         Database    Database    Database
```

A single SessionFactory can create many Sessions.

## 4. Complete Java Example

```java
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionVsSessionFactoryDemo {

    public static void main(String[] args) {

        // SessionFactory is created once.
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        // Session 1: Create student.
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student =
                    new Student("Praveen", "praveen@example.com");

            session.persist(student);

            transaction.commit();

            System.out.println("Student saved: " + student.getId());
        }

        // Session 2: Retrieve student.
        try (Session session = sessionFactory.openSession()) {

            Student student =
                    session.get(Student.class, 1L);

            System.out.println(student);
        }

        // Close SessionFactory only when application is shutting down.
        sessionFactory.close();
    }
}
```

## 5. Difference Between Session and SessionFactory

| Feature | SessionFactory | Session |
|---|---|---|
| Purpose | Creates Sessions | Performs persistence operations |
| Object type | Heavyweight | Lightweight |
| Thread safety | Thread-safe | Not thread-safe |
| Lifecycle | Application-wide | Short-lived |
| Creation | Created once | Created multiple times |
| Quantity | Usually one per database | Multiple |
| Configuration | Holds mapping/config metadata | Uses factory configuration |
| CRUD | Does not directly perform CRUD | Performs CRUD |
| Transaction | Does not represent a unit of work | Works with transactions |
| Cache | Factory-level second-level cache integration | First-level cache |
| Close | Application shutdown | End of unit of work |
| API | `SessionFactory` | `Session` |

## 6. SessionFactory Lifecycle

```text
Application Starts
        |
        v
Build SessionFactory
        |
        v
SessionFactory Available
        |
        v
Open Session
        |
        v
Perform CRUD
        |
        v
Close Session
        |
        v
Open Another Session
        |
        v
Perform More CRUD
        |
        v
Application Shuts Down
        |
        v
Close SessionFactory
```

## 7. Session Lifecycle

```text
Session Created
      |
      v
Persistence Context Created
      |
      v
Begin Transaction
      |
      v
Perform CRUD
      |
      v
Commit / Rollback
      |
      v
Close Session
```

## 8. Session First-Level Cache

Every Session has its own first-level cache.

The first-level cache is enabled by default.

### Example

```java
try (Session session = sessionFactory.openSession()) {

    Student student1 =
            session.get(Student.class, 1L);

    Student student2 =
            session.get(Student.class, 1L);

    System.out.println(student1 == student2);
}
```

Output:

```text
true
```

### Why?

1. First `get()` retrieves the Student from the database.
2. Hibernate stores the entity in the Session's persistence context.
3. Second `get()` for the same entity identity finds it in the same persistence context.
4. Hibernate returns the same managed Java object.

The second call normally does not execute another SELECT.

Note: This is true within the same Session, assuming the entity remains managed and the persistence context has not been cleared.

## 9. Multiple Sessions Example

```java
try (Session session1 = sessionFactory.openSession()) {

    Student student1 =
            session1.get(Student.class, 1L);

    System.out.println(student1);
}

try (Session session2 = sessionFactory.openSession()) {

    Student student2 =
            session2.get(Student.class, 1L);

    System.out.println(student2);
}
```

Here:
- Session 1 has its own first-level cache.
- Session 2 has its own first-level cache.
- The entity is retrieved independently in each Session unless a second-level cache is enabled and applicable.

## 10. Why is SessionFactory Thread-Safe but Session Not?

### SessionFactory

It is designed to be shared among multiple threads because it manages reusable configuration and factory resources.

```java
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
```

### Session

It contains mutable persistence-context state, such as managed entities and their changes.

Sharing a Session between concurrent threads can cause inconsistent state and race conditions.

Correct approach:

```java
// Shared SessionFactory
SessionFactory factory = HibernateUtil.getSessionFactory();

// Each thread or unit of work gets its own Session.
try (Session session = factory.openSession()) {
    // Perform operations.
}
```

## 11. Best Practices

### SessionFactory
- Build once per database.
- Keep it application-wide.
- Reuse it.
- Close it during application shutdown.

### Session
- Open for a short unit of work.
- Do not share between threads.
- Close it after database operations.
- Use transactions for data modifications.
- Avoid keeping Sessions open for long periods.

## 12. Interview Questions

### Q1. What is SessionFactory in Hibernate?

SessionFactory is a thread-safe, heavyweight factory that creates Session instances. It is normally created once per database and reused for the lifetime of the application.

### Q2. What is Session in Hibernate?

Session is a non-thread-safe persistence context used to interact with the database and manage entity objects.

### Q3. Can we create multiple SessionFactory objects?

Yes, but generally one SessionFactory per database is recommended. Multiple factories for the same database can waste resources.

### Q4. Can we share a SessionFactory between multiple threads?

Yes. SessionFactory is thread-safe and designed for concurrent use.

### Q5. Can we share a Session between multiple threads?

No. Session is not thread-safe and should be confined to one thread or unit of work.

### Q6. What happens if SessionFactory is closed?

It can no longer create Sessions. The application must not continue using the closed factory.

### Q7. What happens if Session is closed?

Its persistence context is closed. Managed entities become detached, and further database operations through that Session are not possible.

### Q8. What is the difference between Session and EntityManager?

Session is Hibernate's native API. EntityManager is the standard JPA API. Hibernate implements EntityManager and also provides Session-specific functionality.

## 13. Senior-Level Interview Answer

SessionFactory is a heavyweight, thread-safe object that holds Hibernate's mapping metadata and provides Sessions. We typically initialize it once during application startup and reuse it.

Session is a lightweight, non-thread-safe persistence context responsible for managing entities and database operations within a unit of work. It provides first-level caching, dirty checking, and entity lifecycle management.

In a typical Spring Boot application, the SessionFactory is managed by Hibernate infrastructure, while individual transactions and persistence contexts are usually managed through Spring's transaction management.