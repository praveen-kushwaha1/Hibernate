# Hibernate Transaction

## 1. What Is a Transaction in Hibernate?

A **transaction** in Hibernate is a group of database operations that are treated as a single unit of work.

A transaction ensures that either:
- All database operations are successfully completed.
- Or all database operations are rolled back.

A transaction is used to maintain data consistency.

### Real-World Example: Bank Transfer

Suppose we transfer ₹5,000 from Account A to Account B.

Two operations must happen:

1. Deduct ₹5,000 from Account A.
2. Add ₹5,000 to Account B.

If the first operation succeeds but the second operation fails, the data becomes inconsistent.

A transaction solves this problem.

```text
BEGIN TRANSACTION

Deduct ₹5,000 from Account A
Add ₹5,000 to Account B

COMMIT
```

If any operation fails:

```text
ROLLBACK
```

The database restores the previous state.

---

## 2. Why Do We Need Transactions?

Transactions are required to:

- Maintain database consistency.
- Group multiple database operations.
- Prevent partial updates.
- Roll back operations when an error occurs.
- Safely perform insert, update, and delete operations.

---

## 3. Hibernate Transaction Workflow

```text
Application
    |
    v
SessionFactory
    |
    v
Session
    |
    v
Begin Transaction
    |
    v
Perform Database Operations
    |
    +---- Success ----> Commit
    |
    +---- Failure ----> Rollback
    |
    v
Close Session
```

---

## 4. Hibernate Transaction API

Hibernate provides the `org.hibernate.Transaction` interface.

### Important Methods

| Method | Description |
|---|---|
| `beginTransaction()` | Starts a transaction |
| `commit()` | Permanently commits the transaction |
| `rollback()` | Cancels the transaction |
| `isActive()` | Checks whether the transaction is active |
| `getStatus()` | Returns the transaction status |

Example:

```java
Transaction transaction = session.beginTransaction();

transaction.commit();
```

---

## 5. Maven Dependencies

Add the following dependencies to `pom.xml`.

```xml
<dependencies>

    <!-- Hibernate ORM -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.6.5.Final</version>
    </dependency>

    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.1.0</version>
    </dependency>

</dependencies>
```

---

## 6. Student Entity

### File: `src/main/java/com/hibernate/entity/Student.java`

```java
package com.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a student entity mapped to the database table.
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

---

## 7. Hibernate Transaction Example

### File: `src/main/java/com/hibernate/demo/TransactionDemo.java`

```java
package com.hibernate.demo;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Demonstrates transaction management in Hibernate.
 */
public class TransactionDemo {

    public static void main(String[] args) {

        // Create SessionFactory using Hibernate XML configuration.
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        // Open a Session for database operations.
        try (Session session = sessionFactory.openSession()) {

            // Begin the transaction.
            Transaction transaction = session.beginTransaction();

            try {

                // Create Student object.
                Student student =
                        new Student("Praveen", "praveen@gmail.com");

                // Save the student.
                session.persist(student);

                // Commit the transaction.
                transaction.commit();

                System.out.println("Student saved successfully!");

            } catch (RuntimeException exception) {

                // Roll back if an error occurs.
                if (transaction.isActive()) {
                    transaction.rollback();
                }

                System.out.println("Transaction rolled back!");

                exception.printStackTrace();
            }

        } finally {

            // Close SessionFactory.
            sessionFactory.close();
        }
    }
}
```

### Explanation

```java
Transaction transaction = session.beginTransaction();
```

Starts a new transaction.

```java
session.persist(student);
```

Makes the Student object persistent. The INSERT may be executed immediately or later during flush/commit.

```java
transaction.commit();
```

Commits the transaction.

```java
transaction.rollback();
```

Rolls back the transaction if an error occurs before commit.

---

## 8. Rollback Example

### File: `src/main/java/com/hibernate/demo/RollbackDemo.java`

```java
package com.hibernate.demo;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Demonstrates rollback in Hibernate.
 */
public class RollbackDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            try {

                Student student =
                        new Student("Rahul", "rahul@gmail.com");

                session.persist(student);

                // Simulate an application failure.
                throw new RuntimeException("Something went wrong!");

            } catch (RuntimeException exception) {

                if (transaction.isActive()) {
                    transaction.rollback();
                }

                System.out.println("Rollback executed!");

            }

        } finally {

            sessionFactory.close();
        }
    }
}
```

### Expected Output

```text
Rollback executed!
```

The student record should not be committed to the database.

> Note: A rolled-back transaction does not necessarily restore generated ID values. Database sequences or identity counters may still advance.

---

## 9. ACID Properties

Transactions follow the ACID properties.

| Property | Description | Example |
|---|---|---|
| Atomicity | All operations succeed or fail together | Both bank transfer operations |
| Consistency | Database remains valid | Account balance rules are maintained |
| Isolation | Concurrent transactions do not improperly interfere | Two users updating an account |
| Durability | Committed changes persist | Data remains after application restart |

### Atomicity

Either all operations are completed or none are completed.

### Consistency

A transaction moves the database from one valid state to another valid state.

### Isolation

Concurrent transactions are isolated according to the configured isolation level.

### Durability

Once committed, changes are persisted according to the database's durability guarantees.

---

## 10. Session vs Transaction

| Session | Transaction |
|---|---|
| Represents a Hibernate persistence context | Represents a unit of database work |
| Used to interact with database | Used to commit or roll back changes |
| Created using `openSession()` | Started using `beginTransaction()` |
| Can manage multiple operations | Groups operations atomically |
| Closed using `session.close()` | Completed using `commit()` or `rollback()` |

### Example

```java
Session session = sessionFactory.openSession();

Transaction transaction = session.beginTransaction();

session.persist(student);

transaction.commit();

session.close();
```

---

## 11. Transaction with Update

Hibernate supports automatic dirty checking.

```java
try (Session session = sessionFactory.openSession()) {

    Transaction transaction = session.beginTransaction();

    try {

        Student student = session.get(Student.class, 1L);

        if (student != null) {
            student.setName("Updated Praveen");
        }

        transaction.commit();

    } catch (RuntimeException exception) {

        if (transaction.isActive()) {
            transaction.rollback();
        }

        throw exception;
    }
}
```

### How It Works

1. Hibernate loads the Student entity.
2. The entity becomes managed by the Session.
3. The name is modified.
4. Hibernate detects the change through dirty checking.
5. Hibernate generates an UPDATE statement during flush.
6. The transaction commits the update.

No explicit `session.update()` is needed for a managed entity.

---

## 12. Best Practices

- Always use transactions for database write operations.
- Commit only after all required operations succeed.
- Roll back when an exception occurs.
- Keep transactions short.
- Avoid performing slow network calls inside database transactions.
- Do not share a Hibernate Session across multiple threads.
- Close Sessions and SessionFactories properly.
- Avoid swallowing exceptions without logging or handling them.
- In production applications, use declarative transaction management such as Spring's `@Transactional` when appropriate.

---

## 13. Interview Questions

### Q1. What is a transaction in Hibernate?

A transaction is a unit of work that groups multiple database operations. It ensures that operations are committed together or rolled back together to maintain consistency.

### Q2. Why is transaction management required?

It prevents partial database updates and maintains data integrity when multiple operations are executed.

### Q3. What is the difference between commit and rollback?

- `commit()` permanently commits the changes made by the transaction.
- `rollback()` cancels the uncommitted changes made by the transaction.

### Q4. Is a transaction mandatory for SELECT operations?

A simple read operation may work without explicitly starting a transaction in many configurations. However, transactions are recommended for consistent reads and are generally used for database operations in managed applications.

### Q5. What happens if an exception occurs before commit?

The application should roll back the active transaction. Otherwise, the transaction may remain incomplete or the Session may be left in an unsuitable state.

### Q6. What is dirty checking?

Dirty checking is Hibernate's mechanism for detecting changes in managed entities and generating SQL UPDATE statements during flush.

### Q7. What are ACID properties?

ACID stands for Atomicity, Consistency, Isolation, and Durability. These properties help ensure reliable database transactions.

---

## 14. Interview-Ready Answer

A Hibernate transaction is a unit of work that groups one or more database operations. It helps maintain data consistency by ensuring that operations are committed together or rolled back together.

In Hibernate, we use the `Transaction` interface. We start a transaction using `session.beginTransaction()`, execute database operations, and call `commit()` if everything succeeds. If an exception occurs, we call `rollback()`.

For example, during a bank transfer, money must be deducted from one account and credited to another. Both operations should succeed together. If one operation fails, the transaction is rolled back to avoid inconsistent data.

---

## 15. Practical Learning Checklist

- [ ] Understand what a transaction is.
- [ ] Start a transaction using `beginTransaction()`.
- [ ] Insert a record and commit.
- [ ] Trigger an exception and rollback.
- [ ] Update a record using dirty checking.
- [ ] Understand ACID properties.
- [ ] Explain Session vs Transaction.
- [ ] Answer transaction interview questions.
