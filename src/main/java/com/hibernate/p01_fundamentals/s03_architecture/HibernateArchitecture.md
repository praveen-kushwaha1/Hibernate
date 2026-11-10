# Hibernate Architecture

Typical flow:

1. Application loads configuration.
2. `Configuration` reads Hibernate settings and mappings.
3. `SessionFactory` is built once for the application.
4. Application opens a `Session`.
5. A transaction begins.
6. Session performs persistence operations.
7. Transaction commits or rolls back.
8. Session closes.

Main components:
- Configuration: bootstrap configuration (legacy API; still used in this learning project).
- SessionFactory: immutable, thread-safe factory; normally one per database.
- Session: short-lived, not thread-safe; represents a persistence context.
- Transaction: coordinates atomic database work.
- Entity: mapped Java domain object.
- JDBC connection: Hibernate uses JDBC underneath.
