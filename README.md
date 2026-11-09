# Hibernate Practical Learning

A Maven project for learning JDBC and Hibernate ORM step by step with runnable examples.
**Stack:** Java 21, Maven, Hibernate ORM 6.6, H2 in-memory database. H2 means the first
examples run without installing MySQL. MySQL Connector/J is included for later practice.

## Start
1. Extract the ZIP.
2. Open the `hibernate-practical-learning` folder in IntelliJ IDEA.
3. Set Project SDK to Java 21 and let Maven import dependencies.
4. Run `JdbcConnectionExample`, then `EntityMappingExample`, then `CrudOperationsRunner`.

Terminal (Git Bash / PowerShell):
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.learning.hibernate.s01_jdbc_fundamentals.JdbcConnectionExample"
mvn exec:java -Dexec.mainClass="com.learning.hibernate.s04_entity_mapping.EntityMappingExample"
mvn exec:java -Dexec.mainClass="com.learning.hibernate.s05_crud_operations.CrudOperationsRunner"
```

## Study routine
Read the matching `docs/` page → run the example → inspect generated SQL → change the code →
complete the exercise → answer the interview questions aloud.

The foundational phases contain runnable code. Advanced topics have guided notes and exercises
so you can implement them progressively; they are not represented as fully implemented features.
# Hibernate
