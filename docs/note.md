
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