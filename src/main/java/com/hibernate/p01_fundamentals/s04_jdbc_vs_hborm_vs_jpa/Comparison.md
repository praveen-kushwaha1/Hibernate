# JDBC vs ORM vs JPA vs Hibernate

## 1. Core Difference

| Technology | What is it? | Role |
|---|---|---|
| JDBC | Java API | Direct database access using SQL |
| ORM | Technique | Maps objects to relational tables |
| JPA | Specification | Standard ORM persistence API |
| Hibernate | Framework/provider | ORM implementation and JPA provider |

## 2. Relationship

```text
               Java Application
                      |
          --------------------------
          |                        |
          v                        v
        JDBC API                 JPA API
          |                        |
          v                        v
       JDBC Driver             Hibernate ORM
          |                        |
          |                   Hibernate Engine
          |                        |
          ----------- JDBC ---------
                      |
                      v
                   Database
```

Hibernate may expose its native Session API or implement the JPA EntityManager API.

## 3. Code Comparison

### JDBC

```java
String sql = "INSERT INTO students(name, email) VALUES (?, ?)";

PreparedStatement ps =
        connection.prepareStatement(sql);

ps.setString(1, "Amit");
ps.setString(2, "amit@example.com");

ps.executeUpdate();
```

### ORM Concept

```text
Student Object
      |
      v
ORM maps object to row
      |
      v
SQL INSERT generated/executed
```

ORM is a technique, so it has no single standard CRUD syntax.

### JPA

```java
Student student =
        new Student("Amit", "amit@example.com");

entityManager.persist(student);
```

### Hibernate Native API

```java
Student student =
        new Student("Amit", "amit@example.com");

session.persist(student);
```

## 4. Comparison Table

| Feature | JDBC | ORM | JPA | Hibernate |
|---|---|---|---|---|
| Type | API | Concept | Specification | Framework/provider |
| SQL writing | Mostly manual | Depends on implementation | Often abstracted | Often generated |
| Object mapping | Manual | Main purpose | Standard mapping model | Implemented mapping |
| CRUD | SQL | Depends | EntityManager | Session / EntityManager |
| Relationships | Manual | Supported by ORM tools | Standard annotations | Supported |
| Dirty checking | No built-in entity tracking | Depends | Defined persistence behavior | Supported |
| Portability | SQL/driver dependent | Depends | Provider-level standard | Dialect/provider features |
| Boilerplate | High | Usually lower | Lower | Lower |
| Underlying JDBC | Direct usage | Commonly | Provider commonly uses JDBC | Uses JDBC |

## 5. Which One Should We Use?

### Use JDBC when:
- You need direct control over SQL.
- You are writing specialized or bulk queries.
- You need minimal ORM behavior.
- SQL performance tuning is the main focus.

### Use JPA when:
- You want a standard Java persistence API.
- You want provider flexibility.
- You are building entity-centric applications.

### Use Hibernate when:
- You need a mature ORM provider.
- You want JPA plus Hibernate-specific capabilities.
- You need entity relationships, dirty checking, lazy loading, caching, and HQL.

### Use ORM when:
- Your application domain is naturally modeled using Java objects.
- CRUD and object relationships are common.

## 6. Common Spring Boot Application Stack

```text
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
Spring Data JPA
    |
    v
JPA API
    |
    v
Hibernate ORM
    |
    v
JDBC
    |
    v
MySQL Database
```

Spring Data JPA provides repository abstractions. Hibernate commonly acts as the JPA provider. JDBC is used underneath to communicate with the database.

## 7. Interview One-Liners

**JDBC:** Java API to connect and execute SQL against a database.

**ORM:** Technique to map Java objects to relational database tables.

**JPA:** Standard specification for Java persistence and ORM.

**Hibernate:** ORM framework that implements JPA and provides additional features.

## 8. Important Interview Question

### Is Hibernate a replacement for JDBC?

No. Hibernate uses JDBC internally to communicate with relational databases. Hibernate abstracts many low-level JDBC operations, but JDBC remains part of the underlying database communication.

### Is JPA a framework?

No. JPA is a specification. Hibernate and EclipseLink are implementations/providers.

### Is ORM the same as Hibernate?

No. ORM is a concept/technique. Hibernate is a framework that implements ORM.

### Can we use Hibernate without JPA?

Yes. Hibernate provides its own native API, including Session and SessionFactory. However, Hibernate is also a JPA provider.

### Does Hibernate eliminate SQL?

No. Hibernate generates or executes SQL. Developers should still understand SQL and inspect generated queries for performance.

### Is JDBC faster than Hibernate?

Not universally. JDBC can have less abstraction overhead and gives direct SQL control, but performance depends on query design, mapping, fetching, batching, connection management, and workload. Hibernate can be efficient when used correctly.