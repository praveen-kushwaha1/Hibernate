# Introduction to Hibernate

Hibernate is an Object-Relational Mapping (ORM) framework for Java. It maps Java objects to relational database tables and helps perform database operations with less repetitive JDBC code.

## Key terms
- ORM: maps object-oriented models to relational tables.
- Entity: Java class mapped to a table.
- Session: Hibernate API used to interact with the persistence context.
- SessionFactory: heavyweight, thread-safe factory for Sessions.
- Transaction: unit of work that commits or rolls back database changes.
- HQL: Hibernate Query Language, written in terms of entities and attributes.

## Benefits
- Reduces boilerplate JDBC code.
- Supports object relationships and lifecycle management.
- Provides database portability through dialects.
- Supports caching, lazy loading, and dirty checking.

## Limitations
- ORM behavior can hide SQL and create performance issues if misunderstood.
- N+1 queries, incorrect fetching, and oversized persistence contexts can hurt performance.
- Native SQL may be better for specialized queries.
