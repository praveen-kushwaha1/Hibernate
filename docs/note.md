
hibernate-practical-learning/
│
├── pom.xml
├── README.md
├── .gitignore
│
├── docs/
│   ├── 00-Learning-Roadmap.md
│   ├── 01-Hibernate-Introduction.md
│   ├── 02-Hibernate-Architecture.md
│   ├── 03-Hibernate-vs-JDBC.md
│   ├── 04-Hibernate-vs-JPA.md
│   ├── 05-Hibernate-Configuration.md
│   └── 06-Hibernate-Interview-Preparation.md
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── learning/
│   │   │           └── hibernate/
│   │   │
│   │   │               ├── MainApplication.java
│   │   │               │
│   │   │               ├── config/
│   │   │               │   ├── HibernateUtil.java
│   │   │               │   ├── SessionFactoryProvider.java
│   │   │               │   └── HibernateConfig.java
│   │   │               │
│   │   │               ├── phase01_introduction/
│   │   │               │   ├── basic/
│   │   │               │   ├── architecture/
│   │   │               │   └── jdbccomparison/
│   │   │               │
│   │   │               ├── phase02_xml_configuration/
│   │   │               │   ├── basic/
│   │   │               │   ├── configuration/
│   │   │               │   ├── mapping/
│   │   │               │   ├── crud/
│   │   │               │   └── relationships/
│   │   │               │
│   │   │               ├── phase03_annotation_configuration/
│   │   │               │   ├── entity/
│   │   │               │   ├── table/
│   │   │               │   ├── column/
│   │   │               │   ├── identifier/
│   │   │               │   ├── generatedvalue/
│   │   │               │   └── crud/
│   │   │               │
│   │   │               ├── phase04_entity_lifecycle/
│   │   │               │   ├── transient/
│   │   │               │   ├── persistent/
│   │   │               │   ├── detached/
│   │   │               │   ├── removed/
│   │   │               │   ├── persist/
│   │   │               │   ├── save/
│   │   │               │   ├── update/
│   │   │               │   ├── merge/
│   │   │               │   ├── remove/
│   │   │               │   └── flush/
│   │   │               │
│   │   │               ├── phase05_crud_operations/
│   │   │               │   ├── create/
│   │   │               │   ├── read/
│   │   │               │   ├── update/
│   │   │               │   ├── delete/
│   │   │               │   ├── get-vs-load/
│   │   │               │   ├── getreference/
│   │   │               │   └── batch-operations/
│   │   │               │
│   │   │               ├── phase06_identifier_generation/
│   │   │               │   ├── assigned/
│   │   │               │   ├── identity/
│   │   │               │   ├── sequence/
│   │   │               │   ├── table/
│   │   │               │   └── composite-key/
│   │   │               │
│   │   │               ├── phase07_mapping_relationships/
│   │   │               │   ├── onetoone/
│   │   │               │   ├── onetomany/
│   │   │               │   ├── manytoone/
│   │   │               │   ├── manytomany/
│   │   │               │   ├── bidirectional/
│   │   │               │   ├── unidirectional/
│   │   │               │   ├── mappedby/
│   │   │               │   ├── joincolumn/
│   │   │               │   └── jointable/
│   │   │               │
│   │   │               ├── phase08_embedded_mapping/
│   │   │               │   ├── embeddable/
│   │   │               │   ├── embedded/
│   │   │               │   ├── embeddedid/
│   │   │               │   ├── attributeoverride/
│   │   │               │   ├── elementcollection/
│   │   │               │   └── collectiontable/
│   │   │               │
│   │   │               ├── phase09_inheritance_mapping/
│   │   │               │   ├── singletable/
│   │   │               │   ├── joined/
│   │   │               │   ├── tableperclass/
│   │   │               │   └── mapped-superclass/
│   │   │               │
│   │   │               ├── phase10_hql_queries/
│   │   │               │   ├── basic-hql/
│   │   │               │   ├── where/
│   │   │               │   ├── orderby/
│   │   │               │   ├── groupby/
│   │   │               │   ├── having/
│   │   │               │   ├── aggregate-functions/
│   │   │               │   ├── joins/
│   │   │               │   ├── subqueries/
│   │   │               │   ├── named-queries/
│   │   │               │   └── pagination/
│   │   │               │
│   │   │               ├── phase11_native_sql/
│   │   │               │   ├── native-select/
│   │   │               │   ├── native-insert/
│   │   │               │   ├── native-update/
│   │   │               │   ├── native-delete/
│   │   │               │   └── result-mapping/
│   │   │               │
│   │   │               ├── phase12_criteria_api/
│   │   │               │   ├── basic-criteria/
│   │   │               │   ├── predicates/
│   │   │               │   ├── dynamic-queries/
│   │   │               │   ├── joins/
│   │   │               │   └── pagination/
│   │   │               │
│   │   │               ├── phase13_fetching_strategies/
│   │   │               │   ├── eager/
│   │   │               │   ├── lazy/
│   │   │               │   ├── fetch-join/
│   │   │               │   ├── entity-graph/
│   │   │               │   ├── n-plus-one/
│   │   │               │   └── batch-fetching/
│   │   │               │
│   │   │               ├── phase14_transactions/
│   │   │               │   ├── basic-transaction/
│   │   │               │   ├── commit/
│   │   │               │   ├── rollback/
│   │   │               │   ├── isolation/
│   │   │               │   ├── propagation/
│   │   │               │   └── concurrency/
│   │   │               │
│   │   │               ├── phase15_caching/
│   │   │               │   ├── first-level-cache/
│   │   │               │   ├── second-level-cache/
│   │   │               │   ├── query-cache/
│   │   │               │   └── cache-providers/
│   │   │               │
│   │   │               ├── phase16_advanced_mapping/
│   │   │               │   ├── enum-mapping/
│   │   │               │   ├── date-time-mapping/
│   │   │               │   ├── lob-mapping/
│   │   │               │   ├── converters/
│   │   │               │   ├── versioning/
│   │   │               │   ├── optimistic-locking/
│   │   │               │   └── pessimistic-locking/
│   │   │               │
│   │   │               ├── phase17_performance/
│   │   │               │   ├── batching/
│   │   │               │   ├── statement-optimization/
│   │   │               │   ├── fetch-optimization/
│   │   │               │   ├── connection-pooling/
│   │   │               │   └── sql-logging/
│   │   │               │
│   │   │               ├── phase18_hibernate_events/
│   │   │               │   ├── entity-listeners/
│   │   │               │   ├── interceptors/
│   │   │               │   ├── event-listeners/
│   │   │               │   └── lifecycle-callbacks/
│   │   │               │
│   │   │               ├── phase19_hibernate_advanced/
│   │   │               │   ├── filters/
│   │   │               │   ├── soft-delete/
│   │   │               │   ├── multitenancy/
│   │   │               │   ├── auditing/
│   │   │               │   ├── schema-generation/
│   │   │               │   └── stored-procedures/
│   │   │               │
│   │   │               └── phase20_real_world_project/
│   │   │                   ├── entity/
│   │   │                   ├── repository/
│   │   │                   ├── service/
│   │   │                   ├── dto/
│   │   │                   ├── exception/
│   │   │                   ├── util/
│   │   │                   └── MainApplication.java
│   │   │
│   │   └── resources/
│   │       │
│   │       ├── hibernate.cfg.xml
│   │       ├── hibernate-xml.cfg.xml
│   │       ├── hibernate-annotation.cfg.xml
│   │       │
│   │       ├── mappings/
│   │       │   ├── Student.hbm.xml
│   │       │   ├── Employee.hbm.xml
│   │       │   ├── Department.hbm.xml
│   │       │   ├── Address.hbm.xml
│   │       │   └── relationships/
│   │       │
│   │       ├── sql/
│   │       │   ├── schema.sql
│   │       │   ├── sample-data.sql
│   │       │   └── cleanup.sql
│   │       │
│   │       └── logback.xml
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── learning/
│                   └── hibernate/
│                       ├── xml/
│                       ├── annotation/
│                       ├── relationships/
│                       ├── hql/
│                       ├── transactions/
│                       └── performance/
│
└── learning-notes/
├── concepts/
├── interview-questions/
├── sql-output/
└── mistakes-and-solutions/














I recommend organizing the complete Hibernate practical-learning project into 15 sequential PRs, covering XML-based configuration, XML mapping, annotation-based mapping, Hibernate internals, queries, relationships, transactions, caching, performance and real-world implementation.

The goal is to ensure that no important Hibernate concept is skipped and every PR contains runnable coding exercises.
Hibernate Practical Learning – 15 PR Roadmap
Beginner to Advanced
15 PRs
Core Java + Maven + MySQL

Complete PR-wise implementation plan
PR	Name	Concepts covered
PR-01	Hibernate Fundamentals	ORM, architecture, JDBC vs Hibernate, JPA vs Hibernate, SessionFactory, Session, Transaction
PR-02	XML Configuration & Mapping	hibernate.cfg.xml, .hbm.xml, mapping elements, XML-based CRUD
PR-03	Annotation-Based Configuration	@Entity, @Table, @Column, @Id, @GeneratedValue, @Basic, @Transient
PR-04	Entity Lifecycle & CRUD	Transient, Persistent, Detached, Removed, persist, merge, remove, refresh, flush, CRUD
PR-05	Identifier Generation & Composite Keys	Assigned, Identity, Sequence, Table, UUID, @EmbeddedId, @IdClass
PR-06	Entity Relationships	One-to-One, One-to-Many, Many-to-One, Many-to-Many, bidirectional, unidirectional
PR-07	Advanced Relationship Mapping	mappedBy, cascade, orphanRemoval, fetch types, join tables, collection mapping
PR-08	Embedded & Inheritance Mapping	@Embeddable, @Embedded, @ElementCollection, Single Table, Joined, Table Per Class
PR-09	HQL / JPQL	Select, Where, Order By, Group By, Having, Joins, Subqueries, Aggregates, Pagination
PR-10	Native SQL & Criteria API	Native SELECT, INSERT, UPDATE, DELETE, result mapping, dynamic queries, predicates
PR-11	Fetching Strategies & Performance	Lazy, Eager, N+1, Fetch Join, Entity Graph, Batch Fetching, SQL optimization
PR-12	Transactions & Concurrency	Commit, Rollback, ACID, isolation, optimistic locking, pessimistic locking, @Version
PR-13	Hibernate Caching	First-Level Cache, Second-Level Cache, Query Cache, cache providers, cache eviction
PR-14	Advanced Hibernate Features	Interceptors, Events, Listeners, Filters, Soft Delete, Auditing, Multitenancy, Stored Procedures
PR-15	Real-World Banking Project	Complete CRUD, relationships, transactions, locking, auditing, pagination, performance, testing


Detailed folder structure for each PR
Use this structure inside your existing Maven project.

hibernate-practical-learning/
│
├── pom.xml
├── README.md
│
├── docs/
│   ├── roadmap.md
│   ├── coding-standards.md
│   └── interview-notes.md
│
├── src/
│   ├── main/
│   │   ├── java/com/learning/hibernate/
│   │   │
│   │   ├── resources/
│   │   │   ├── hibernate.cfg.xml
│   │   │   ├── hibernate-xml.cfg.xml
│   │   │   ├── hibernate-annotation.cfg.xml
│   │   │   ├── mappings/
│   │   │   ├── sql/
│   │   │   └── logback.xml
│   │   │
│   │   └── ...
│   │
│   └── test/
│       └── java/com/learning/hibernate/
│
└── learning-notes/
├── PR-01/
├── PR-02/
├── PR-03/
├── PR-04/
├── PR-05/
├── PR-06/
├── PR-07/
├── PR-08/
├── PR-09/
├── PR-10/
├── PR-11/
├── PR-12/
├── PR-13/
├── PR-14/
└── PR-15/



PR implementation details
PR-01: Hibernate Fundamentals
phase01_fundamentals/
├── introduction/
├── orm/
├── architecture/
├── jdbc-vs-hibernate/
├── jpa-vs-hibernate/
├── session/
├── session-factory/
├── transaction/
└── basic-application/


PR-02: XML Configuration and Mapping
phase02_xml_configuration/
├── configuration/
│   ├── HibernateConfigExample.java
│   └── DatabasePropertiesExample.java
├── mapping/
│   ├── Student.java
│   ├── Student.hbm.xml
│   └── Employee.hbm.xml
├── identifier/
├── property-mapping/
├── component-mapping/
├── collection-mapping/
├── relationships/
└── crud/


Practice both XML configuration and XML mapping independently.
PR-03: Annotation-Based Configuration
phase03_annotations/
├── entity/
├── table/
├── column/
├── identifier/
├── generated-value/
├── basic/
├── transient/
├── access-type/
├── enum-mapping/
└── crud/


PR-04: Entity Lifecycle and CRUD
phase04_entity_lifecycle/
├── transient/
├── persistent/
├── detached/
├── removed/
├── persist/
├── merge/
├── remove/
├── refresh/
├── flush/
├── clear/
├── evict/
└── crud/


Also compare legacy APIs such as save() and update() with modern Hibernate APIs such as persist() and merge().
PR-05: Identifier Generation
phase05_identifier_generation/
├── assigned/
├── identity/
├── sequence/
├── table/
├── uuid/
├── embedded-id/
├── id-class/
└── composite-key/
Identifier Generation & Composite Keys	Assigned, Identity, Sequence, Table, UUID, @EmbeddedId, @IdClass


PR-06: Entity Relationships
phase06_relationships/
├── one-to-one/
├── one-to-many/
├── many-to-one/
├── many-to-many/
├── unidirectional/
└── bidirectional/


Use practical examples:
- User and UserProfile
- Department and Employee
- Student and Course
  PR-07: Advanced Relationship Mapping
  phase07_advanced_relationships/
  ├── mapped-by/
  ├── join-column/
  ├── join-table/
  ├── cascade/
  ├── orphan-removal/
  ├── lazy-fetching/
  ├── eager-fetching/
  ├── set-mapping/
  ├── list-mapping/
  ├── map-mapping/
  ├── bag-mapping/
  └── collection-table/


PR-08: Embedded and Inheritance Mapping
phase08_embedded_inheritance/
├── embeddable/
├── embedded/
├── embedded-id/
├── attribute-override/
├── element-collection/
├── mapped-superclass/
├── single-table/
├── joined/
└── table-per-class/


PR-09: HQL and JPQL
phase09_hql_jpql/
├── select/
├── where/
├── order-by/
├── group-by/
├── having/
├── aggregate-functions/
├── inner-join/
├── left-join/
├── fetch-join/
├── subqueries/
├── named-queries/
├── parameters/
└── pagination/


PR-10: Native SQL and Criteria API
phase10_queries/
├── native-sql/
│   ├── select/
│   ├── insert/
│   ├── update/
│   ├── delete/
│   ├── stored-procedure/
│   └── result-mapping/
│
└── criteria-api/
├── basic/
├── predicates/
├── conjunction/
├── disjunction/
├── dynamic-queries/
├── joins/
└── pagination/


PR-11: Fetching and Performance
phase11_fetching_performance/
├── lazy-loading/
├── eager-loading/
├── n-plus-one/
├── fetch-join/
├── entity-graph/
├── batch-fetching/
├── jdbc-batching/
├── sql-optimization/
├── connection-pooling/
└── sql-logging/


PR-12: Transactions and Concurrency
phase12_transactions/
├── transaction-basics/
├── commit/
├── rollback/
├── acid/
├── isolation-levels/
├── dirty-read/
├── non-repeatable-read/
├── phantom-read/
├── optimistic-locking/
├── pessimistic-locking/
├── versioning/
└── concurrent-transactions/


PR-13: Hibernate Caching
phase13_caching/
├── first-level-cache/
├── second-level-cache/
├── query-cache/
├── cache-regions/
├── cache-eviction/
├── cache-invalidation/
└── cache-provider/


PR-14: Advanced Hibernate
phase14_advanced/
├── entity-listeners/
├── lifecycle-callbacks/
├── interceptors/
├── event-listeners/
├── filters/
├── soft-delete/
├── auditing/
├── multitenancy/
├── converters/
├── custom-types/
├── schema-generation/
└── stored-procedures/


PR-15: Real-World Banking Project
phase15_banking_application/
├── entity/
│   ├── Customer.java
│   ├── Account.java
│   ├── Transaction.java
│   ├── Beneficiary.java
│   └── AuditLog.java
│
├── repository/
│   ├── CustomerRepository.java
│   ├── AccountRepository.java
│   └── TransactionRepository.java
│
├── service/
│   ├── CustomerService.java
│   ├── AccountService.java
│   └── FundTransferService.java
│
├── dto/
├── exception/
├── config/
├── auditing/
├── util/
└── MainApplication.java


Implement:
- Customer and account management.
- Account-to-customer relationships.
- Fund transfers between accounts.
- Transaction management and rollback.
- Concurrent fund transfers.
- Optimistic locking.
- Audit logs.
- HQL and pagination.
- N+1 problem resolution.
- Batch processing.
- Unit and integration tests.

Git PR naming convention
Use these branch names consistently:
PR	Branch name
01	feature/PR-01-hibernate-fundamentals
02	feature/PR-02-xml-configuration
03	feature/PR-03-annotation-mapping
04	feature/PR-04-entity-lifecycle-crud
05	feature/PR-05-identifier-generation
06	feature/PR-06-entity-relationships
07	feature/PR-07-advanced-relationships
08	feature/PR-08-embedded-inheritance
09	feature/PR-09-hql-jpql
10	feature/PR-10-native-sql-criteria
11	feature/PR-11-fetching-performance
12	feature/PR-12-transactions-concurrency
13	feature/PR-13-hibernate-caching
14	feature/PR-14-advanced-hibernate
15	feature/PR-15-banking-project

Important learning rules
1. Every concept must have at least one runnable Java example.
2. Keep XML and annotation examples separate initially.
3. Every CRUD example should demonstrate generated SQL.
4. Use MySQL to understand actual database behaviour.
5. Include negative scenarios, exceptions and rollback examples.
6. Add a README and learning notes for every PR.
7. Write unit/integration tests wherever applicable.
8. Don't introduce Spring Boot until the core Hibernate learning project is completed.
   One additional recommendation: Use Hibernate 6.6 with Java 17 throughout the project. Some older APIs, such as save(), update() and load(), should be studied for legacy interview knowledge, but clearly mark them as deprecated or legacy where applicable.

This 15-PR roadmap can become a complete Hibernate practical-learning GitHub repository, from beginner concepts to senior-level interview preparation.












This might also interest you.


Ad
Ad options



Learn more

Category 1: Architecture, Core Concepts & Entity Lifecycle (Q1 – Q20)
1. What is Hibernate and how does it relate to JPA?
   Hibernate is an Object-Relational Mapping (ORM) framework for Java that simplifies database interactions by mapping Java classes to database tables.

JPA (Jakarta Persistence API) is a specification/standard for ORM in Java. Hibernate is a vendor implementation of the JPA specification. While Hibernate provides its own native APIs (Session, SessionFactory), it fully implements JPA APIs (EntityManager, EntityManagerFactory).

2. Explain the core interfaces/classes in Hibernate Architecture.
   Configuration: Used to configure Hibernate, read mapping files (hibernate.cfg.xml), and bootstrap the SessionFactory.

SessionFactory: A heavy, thread-safe, immutable factory object that creates Session instances. Usually created once per application lifecycle.

Session: A lightweight, non-thread-safe object representing a single-threaded unit of work with the database (analogous to a JPA EntityManager).

Transaction: Encapsulates atomic units of work, keeping database operations transactional.

Query / Criteria: Used to write database queries using HQL (Hibernate Query Language) or Criteria API.

3. What are the states of a Persistent Entity (Entity Lifecycle)?
   An entity instance can be in one of four states within the Hibernate Persistence Context:

Transient: Newly created with new, not associated with any Session, and has no representation in the database (no identifier).

Persistent: Associated with an active Session and has a database identifier. Any changes made to it are automatically tracked and synchronized to the database upon flushing/committing.

Detached: The Session that created/loaded the entity has been closed. The object still exists and has a database ID, but changes are not automatically synced to the database.

Removed: The entity has been marked for deletion via session.remove() (or session.delete()) and will be deleted when the transaction commits or flush occurs.

Quick Index: Core Architecture & Lifecycle Questions (Q4 – Q20)
Q4: What is the difference between getCurrentSession() and openSession()?

Q5: What is the Hibernate Persistence Context (First-Level Cache)?

Q6: Explain Dirty Checking in Hibernate. How does it work?

Q7: What is the role of flush() in Hibernate? When does flushing occur?

Q8: How does EntityManager map to Hibernate's Session?

Q9: What is metamodel in Hibernate/JPA and why is it used?

Q10: How does Hibernate bootstrap in modern Spring Boot applications?

Q11–Q20: Covering configuration properties, connection pooling, interceptors, event listeners, and custom dialects.

Category 2: Methods, Mappings & Associations (Q21 – Q40)
21. What is the difference between save(), persist(), saveOrUpdate(), and merge()?
    persist(entity): JPA standard method. Makes a transient instance persistent. It returns void and guarantees that the entity will be assigned an identifier when executed inside a transaction.

save(entity): Hibernate-specific. Saves a transient instance, returning the generated identifier immediately (even outside a transaction in some configurations).

merge(entity): Copies the state of the given detached object onto the persistent entity with the same identifier, or creates a new persistent instance if none exists, returning the managed instance.

update(entity): Hibernate-specific. Re-attaches a detached instance to the current session (throws an exception if another persistent instance with the same identifier is already associated).

22. What is the difference between get() and load()?
    Feature	get()	load()
    Database Hit	Hits the database immediately.	Returns a proxy object immediately without hitting DB (lazy loading).
    If Record Not Found	Returns null.	Throws an EntityNotFoundException (or ObjectNotFoundException) when the proxy is accessed.
    Use Case	When you are unsure if the record exists.	When you are sure the record exists and want to optimize performance (e.g., establishing foreign key relations).
23. Explain fetching strategies: Eager vs. Lazy Loading.
    Eager Loading (FetchType.EAGER): Associated entities/collections are fetched immediately along with the parent entity using a SQL JOIN. Can lead to performance degradation or massive queries (Cartesian product problem).

Lazy Loading (FetchType.LAZY): Associated entities are loaded on-demand when the getter method is explicitly invoked, using proxy objects. This is the default for @OneToMany and @ManyToMany.

Quick Index: Mappings & Associations Questions (Q24 – Q40)
Q24: Explain @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany annotations.

Q25: What is the difference between unidirectional and bidirectional associations?

Q26: What is the purpose of mappedBy in bidirectional relationships? Where should it be placed?

Q27: What is an Entity Graph (@NamedEntityGraph) and how does it solve N+1 query problems?

Q28: How do you map composite primary keys using @EmbeddedId vs @IdClass?

Q29: What is @MapsId and when is it used?

Q30–Q40: Inheritance mapping strategies (Single Table, Joined, Table per Class), orphan removal, cascade types (CascadeType.ALL, PERSIST, REMOVE), and @ElementCollection.

Category 3: HQL, JPQL, Criteria API & Performance (Q41 – Q70)
41. What is the N+1 Select Problem and how do you solve it?
    The N+1 select problem occurs when an application executes 1 query to fetch a parent list of
    N entities, and then executes
    N additional queries to fetch the child collections or associations for each parent.

Solutions:

Fetch Join: Use JOIN FETCH in HQL/JPQL (e.g., SELECT p FROM Post p JOIN FETCH p.comments).

Entity Graphs: Use @EntityGraph in Spring Data JPA.

Batch Fetching: Configure @BatchSize(size = 20) on collections to fetch child records in batches rather than individually.

42. Compare HQL, JPQL, Criteria API, and Native SQL.
    JPQL: Standardized JPA query language operating on entity objects, not database tables.

HQL: Hibernate's extension of JPQL, supporting extra features like explicit joins, pagination, and dynamic queries.

Criteria API: Type-safe, programmatic way to build queries dynamically in Java using code expressions (ideal for search filters with dynamic parameters).

Native SQL: Direct SQL execution for database-specific functions or extreme query optimization.

Quick Index: Query & Performance Questions (Q43 – Q70)
Q43: How do you implement pagination in HQL and Criteria queries? (setFirstResult(), setMaxResults())

Q44: What are named queries (@NamedQuery)?

Q45: What is query parameter binding and why is it mandatory to prevent SQL injection?

Q46: What are DTO Projections (SELECT new com.dto.UserDTO(...)) in JPQL?

Q47–Q70: Covering bulk updates/deletes, criteria builders, stored procedures, second-level cache query caching, and stateless sessions (StatelessSession).

Category 4: Caching & Concurrency (Q71 – Q85)
71. Explain the First-Level and Second-Level Caches in Hibernate.
    First-Level Cache (L1): Associated with the Session (EntityManager) object. It is enabled by default and cannot be disabled. Objects loaded within a session are stored here; subsequent requests for the same ID within the same session return the cached instance without hitting the database.

Second-Level Cache (L2): Associated with the SessionFactory. It is optional and shared across multiple sessions/users. It reduces database trips for read-heavy reference data. Common providers include Ehcache, Infinispan, and Redis.

72. What are the caching concurrency strategies in Hibernate?
    READ_ONLY: For data that never changes (throws an exception if modification is attempted).

READ_WRITE: Maintains consistency by locking cached items when updated. Suitable for data read often but updated infrequently.

NONSTRICT_READ_WRITE: Does not guarantee strict consistency; updates invalidate the cache. Good when stale data is acceptable for short windows.

TRANSACTIONAL: Fully JTA-compliant cache management for JTA environments.

73. Explain Optimistic vs. Pessimistic Locking.
    Optimistic Locking: Assumes conflicts are rare. Uses a version column (@Version) or timestamp. When updating, Hibernate checks if the version in the DB matches the version read; if another transaction modified it, an OptimisticLockException is thrown.

Pessimistic Locking: Assumes conflicts are frequent. Locks database rows explicitly using database locking mechanisms (PessimisticRead, PessimisticWrite) via LockModeType, preventing other transactions from reading/writing until the lock is released.

Quick Index: Concurrency & Caching Questions (Q74 – Q85)
Q74: How do you configure a Second-Level Cache in Hibernate?

Q75: What is Query Cache and how does it differ from L2 Cache?

Q76–Q85: Handling stale state, detached entity merging collisions, concurrency bottlenecks, transaction isolation levels, and ACID properties in ORM contexts.

Category 5: Best Practices, Troubleshooting & Advanced Topics (Q86 – Q100)
86. How do you handle lazy loading exceptions (LazyInitializationException)?
    A LazyInitializationException occurs when code attempts to access a lazy-loaded collection or association after the Hibernate Session has been closed (common in web controllers or asynchronous threads).

Solutions:

Open Session in View (OSIV) pattern (though often discouraged for microservices).

DTO Projections / JPQL Joins: Fetch all required data upfront within the transactional service layer.

Hibernate.initialize(entity.getAssociation()): Explicitly initialize proxies while the session is still open.

87. What are the best practices for designing entities in Hibernate?
    Always override equals() and hashCode() using natural business keys or unique IDs rather than generated database IDs.

Avoid making all associations EAGER. Default to LAZY.

Implement @Version for optimistic concurrency control on mutable entities.

Use stateless sessions (StatelessSession) for bulk data loading/processing to bypass persistence context overhead.

Keep entity classes clean; avoid placing heavy business logic inside domain entities.

Quick Index: Advanced & Best Practice Questions (Q88 – Q100)
Q88: How do you map JSON/JSONB columns in MySQL or PostgreSQL using Hibernate?

Q89: What is @DynamicUpdate and @DynamicInsert, and when should you use them?

Q90: How do you audit database changes automatically using Hibernate Envers?

Q91–Q100: Covering soft deletes (@SQLDelete), UUID generation strategies (@UuidGenerator), multi-tenancy architectures, bytecode enhancement, tuning batch sizes (hibernate.jdbc.batch_size), and migrating from legacy .hbm.xml to JPA annotations.