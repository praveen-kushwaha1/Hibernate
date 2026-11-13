package com.hibernate.p08_querys.p03_criteriaapi;

import com.hibernate.p08_querys.p03_criteriaapi.dto.EmployeeDTO;

import com.hibernate.p08_querys.p03_criteriaapi.entity.Department;
import com.hibernate.p08_querys.p03_criteriaapi.entity.Employee;
import com.hibernate.p08_querys.p03_criteriaapi.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            // BASIC QUERIES
            basicSelect();
            selectWithWhere();
            equalCondition();
            // comparisonConditions();
            betweenCondition();
            likeCondition();
            //inCondition();
            nullCondition();

            // COMBINING CONDITIONS
            //andCondition();
            orCondition();
            //notCondition();
            //dynamicSearch();

            // SORTING AND RESULTS
            sorting();
            distinctResults();
            pagination();

            // AGGREGATE AND GROUPING
            countEmployees();
            aggregateFunctions();
            groupByAndHaving();

            // JOINS AND PROJECTIONS
            innerJoin();
            leftJoin();
            fetchJoin();
            tupleProjection();
            dtoProjection();

            // ADVANCED QUERIES
            subquery();
            existsSubquery();
            caseExpression();
            stringFunctions();

            // BULK OPERATIONS
            // updateEmployeeSalary();
            // deleteEmployee();

        } finally {
            // Close EntityManagerFactory after all examples finish.
            JPAUtil.shutdown();
        }
    }

    // --------------------------------------------------
    // 1. BASIC SELECT
    // --------------------------------------------------

    public static void basicSelect() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            // CriteriaBuilder creates Criteria API query components.
            CriteriaBuilder cb = em.getCriteriaBuilder();

            // CriteriaQuery defines the result type.
            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            // Root represents the Employee entity in the FROM clause.
            Root<Employee> root = cq.from(Employee.class);

            // SELECT e FROM Employee e
            cq.select(root);

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 2. SELECT WITH WHERE
    // --------------------------------------------------

    public static void selectWithWhere() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // WHERE salary > 30000
            Predicate condition =
                    cb.greaterThan(
                            root.<BigDecimal>get("salary"),
                            new BigDecimal("30000")
                    );

            cq.select(root).where(condition);

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 3. EQUAL CONDITION
    // --------------------------------------------------

    public static void equalCondition() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // WHERE name = 'John'
            cq.select(root)
              .where(cb.equal(root.get("name"), "John"));

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 4. COMPARISON CONDITIONS
    // >, >=, <, <=
    // --------------------------------------------------

//    public static void comparisonConditions() {
//
//        EntityManager em = JPAUtil.getSessionFactory().openSession();;
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//
//            CriteriaQuery<Employee> cq =
//                    cb.createQuery(Employee.class);
//
//            Root<Employee> root = cq.from(Employee.class);
//
//            // WHERE salary >= 40000 AND age < 40
//            Predicate salaryCondition =
//                    cb.greaterThanOrEqualTo(
//                            root.<BigDecimal>get("salary"),
//                            new BigDecimal("40000")
//                    );
//
//            Predicate ageCondition =
//                    cb.lessThan(
//                            root.<Integer>get("age"),
//                            40
//                    );
//
//            cq.select(root)
//              .where(salaryCondition, ageCondition);
//
//            List<Employee> employees =
//                    em.createQuery(cq).getResultList();
//
//            employees.forEach(System.out::println);
//
//        } finally {
//            em.close();
//        }
//    }

    // --------------------------------------------------
    // 5. BETWEEN CONDITION
    // --------------------------------------------------

    public static void betweenCondition() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // WHERE salary BETWEEN 30000 AND 60000
            Predicate condition =
                    cb.between(
                            root.<BigDecimal>get("salary"),
                            new BigDecimal("30000"),
                            new BigDecimal("60000")
                    );

            cq.select(root).where(condition);

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 6. LIKE CONDITION
    // --------------------------------------------------

    public static void likeCondition() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // WHERE name LIKE '%john%'
            Predicate condition =
                    cb.like(
                            cb.lower(root.<String>get("name")),
                            "%john%"
                    );

            cq.select(root).where(condition);

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 7. IN CONDITION
    // --------------------------------------------------

//    public static void inCondition() {
//
//        EntityManager em = JPAUtil.getSessionFactory().openSession();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//
//            CriteriaQuery<Employee> cq =
//                    cb.createQuery(Employee.class);
//
//            Root<Employee> root = cq.from(Employee.class);
//
//            // WHERE age IN (25, 30, 35)
//            Predicate condition =
//                    root.<Integer>get("age").in(25, 30, 35);
//
//            cq.select(root).where(condition);
//
//            List<Employee> employees =
//                    em.createQuery(cq).getResultList();
//
//            employees.forEach(System.out::println);
//
//        } finally {
//            em.close();
//        }
//    }

    // --------------------------------------------------
    // 8. NULL CONDITION
    // --------------------------------------------------

    public static void nullCondition() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // Find employees without a department.
            cq.select(root)
              .where(cb.isNull(root.get("department")));

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 9. AND CONDITION
    // --------------------------------------------------

//    public static void andCondition() {
//
//        EntityManager em = JPAUtil.getSessionFactory().openSession();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//
//            CriteriaQuery<Employee> cq =
//                    cb.createQuery(Employee.class);
//
//            Root<Employee> root = cq.from(Employee.class);
//
//            Predicate salary =
//                    cb.greaterThan(
//                            root.<BigDecimal>get("salary"),
//                            new BigDecimal("30000")
//                    );
//
//            Predicate age =
//                    cb.greaterThanOrEqualTo(
//                            root.<Integer>get("age"),
//                            25
//                    );
//
//            // Both conditions must be true.
//            cq.select(root).where(cb.and(salary, age));
//
//            List<Employee> employees =
//                    em.createQuery(cq).getResultList();
//
//            employees.forEach(System.out::println);
//
//        } finally {
//            em.close();
//        }
//    }

    // --------------------------------------------------
    // 10. OR CONDITION
    // --------------------------------------------------

    public static void orCondition() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            Predicate it =
                    cb.equal(
                            root.get("department").get("name"),
                            "IT"
                    );

            Predicate hr =
                    cb.equal(
                            root.get("department").get("name"),
                            "HR"
                    );

            // Either condition can be true.
            cq.select(root).where(cb.or(it, hr));

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 11. NOT CONDITION
    // --------------------------------------------------

//    public static void notCondition() {
//
//        EntityManager em = JPAUtil.getSessionFactory().openSession();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//
//            CriteriaQuery<Employee> cq =
//                    cb.createQuery(Employee.class);
//
//            Root<Employee> root = cq.from(Employee.class);
//
//            // WHERE NOT (age > 40)
//            Predicate condition =
//                    cb.not(
//                            cb.greaterThan(
//                                    root.<Integer>get("age"),
//                                    40
//                            )
//                    );
//
//            cq.select(root).where(condition);
//
//            List<Employee> employees =
//                    em.createQuery(cq).getResultList();
//
//            employees.forEach(System.out::println);
//
//        } finally {
//            em.close();
//        }
//    }

    // --------------------------------------------------
    // 12. DYNAMIC SEARCH
    // --------------------------------------------------

    public static void dynamicSearch() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // These values can come from API search parameters.
            String name = "john";
            BigDecimal minimumSalary = new BigDecimal("30000");
            Integer minimumAge = 25;

            List<Predicate> predicates = new ArrayList<>();

            // Add conditions only when values are provided.
            if (name != null && !name.isBlank()) {
                predicates.add(
                        cb.like(
                                cb.lower(root.<String>get("name")),
                                "%" + name.toLowerCase() + "%"
                        )
                );
            }

            if (minimumSalary != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.<BigDecimal>get("salary"),
                                minimumSalary
                        )
                );
            }

            if (minimumAge != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.<Integer>get("age"),
                                minimumAge
                        )
                );
            }

            // Combine all supplied conditions using AND.
            cq.select(root)
              .where(predicates.toArray(new Predicate[0]));

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 13. SORTING
    // --------------------------------------------------

    public static void sorting() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // ORDER BY salary DESC, name ASC
            cq.select(root)
              .orderBy(
                      cb.desc(root.get("salary")),
                      cb.asc(root.get("name"))
              );

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 14. DISTINCT
    // --------------------------------------------------

    public static void distinctResults() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Department> cq =
                    cb.createQuery(Department.class);

            Root<Department> root = cq.from(Department.class);

            Join<Department, Employee> employeeJoin =
                    root.join("employees", JoinType.INNER);

            cq.select(root).distinct(true);

            List<Department> departments =
                    em.createQuery(cq).getResultList();

            departments.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 15. PAGINATION
    // --------------------------------------------------

    public static void pagination() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            cq.select(root).orderBy(cb.asc(root.get("id")));

            int pageNumber = 0;
            int pageSize = 5;

            List<Employee> employees =
                    em.createQuery(cq)
                      .setFirstResult(pageNumber * pageSize)
                      .setMaxResults(pageSize)
                      .getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 16. COUNT
    // --------------------------------------------------

    public static void countEmployees() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Long> cq =
                    cb.createQuery(Long.class);

            Root<Employee> root = cq.from(Employee.class);

            cq.select(cb.count(root));

            Long count = em.createQuery(cq).getSingleResult();

            System.out.println("Total Employees: " + count);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 17. AGGREGATE FUNCTIONS
    // SUM, AVG, MIN, MAX
    // --------------------------------------------------

    public static void aggregateFunctions() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Object[]> cq =
                    cb.createQuery(Object[].class);

            Root<Employee> root = cq.from(Employee.class);

            cq.multiselect(
                    cb.sum(root.<BigDecimal>get("salary")),
                    cb.avg(root.<BigDecimal>get("salary")),
                    cb.min(root.<BigDecimal>get("salary")),
                    cb.max(root.<BigDecimal>get("salary"))
            );

            Object[] result =
                    em.createQuery(cq).getSingleResult();

            System.out.println("Total Salary: " + result[0]);
            System.out.println("Average Salary: " + result[1]);
            System.out.println("Minimum Salary: " + result[2]);
            System.out.println("Maximum Salary: " + result[3]);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 18. GROUP BY AND HAVING
    // --------------------------------------------------

    public static void groupByAndHaving() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Tuple> cq =
                    cb.createTupleQuery();

            Root<Employee> root = cq.from(Employee.class);

            Join<Employee, Department> department =
                    root.join("department", JoinType.INNER);

            Expression<Long> employeeCount =
                    cb.count(root);

            cq.multiselect(
                    department.get("name").alias("departmentName"),
                    employeeCount.alias("employeeCount")
            );

            cq.groupBy(department.get("name"));

            cq.having(cb.gt(employeeCount, 1L));

            List<Tuple> results =
                    em.createQuery(cq).getResultList();

            for (Tuple tuple : results) {
                System.out.println(
                        "Department: " +
                        tuple.get("departmentName") +
                        ", Employees: " +
                        tuple.get("employeeCount")
                );
            }

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 19. INNER JOIN
    // --------------------------------------------------

    public static void innerJoin() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            Join<Employee, Department> department =
                    root.join("department", JoinType.INNER);

            cq.select(root)
              .where(cb.equal(department.get("name"), "IT"));

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 20. LEFT JOIN
    // --------------------------------------------------

    public static void leftJoin() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Tuple> cq =
                    cb.createTupleQuery();

            Root<Department> root =
                    cq.from(Department.class);

            Join<Department, Employee> employee =
                    root.join("employees", JoinType.LEFT);

            cq.multiselect(
                    root.get("name").alias("departmentName"),
                    employee.get("name").alias("employeeName")
            );

            List<Tuple> results =
                    em.createQuery(cq).getResultList();

            for (Tuple tuple : results) {
                System.out.println(
                        "Department: " +
                        tuple.get("departmentName") +
                        ", Employee: " +
                        tuple.get("employeeName")
                );
            }

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 21. FETCH JOIN
    // --------------------------------------------------

    public static void fetchJoin() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // Fetch department together with Employee.
            root.fetch("department", JoinType.INNER);

            cq.select(root);

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(employee -> {
                System.out.println(employee.getName());
                System.out.println(
                        employee.getDepartment().getName()
                );
            });

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 22. TUPLE PROJECTION
    // --------------------------------------------------

    public static void tupleProjection() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Tuple> cq =
                    cb.createTupleQuery();

            Root<Employee> root = cq.from(Employee.class);

            cq.multiselect(
                    root.get("name").alias("employeeName"),
                    root.get("salary").alias("employeeSalary")
            );

            List<Tuple> results =
                    em.createQuery(cq).getResultList();

            for (Tuple tuple : results) {
                System.out.println(
                        "Name: " +
                        tuple.get("employeeName") +
                        ", Salary: " +
                        tuple.get("employeeSalary")
                );
            }

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 23. DTO PROJECTION
    // --------------------------------------------------

    public static void dtoProjection() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<EmployeeDTO> cq =
                    cb.createQuery(EmployeeDTO.class);

            Root<Employee> root = cq.from(Employee.class);

            Join<Employee, Department> department =
                    root.join("department", JoinType.INNER);

            // Calls the matching EmployeeDTO constructor.
            cq.select(
                    cb.construct(
                            EmployeeDTO.class,
                            root.get("name"),
                            root.get("salary"),
                            department.get("name")
                    )
            );

            List<EmployeeDTO> results =
                    em.createQuery(cq).getResultList();

            results.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 24. SUBQUERY
    // --------------------------------------------------

    public static void subquery() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Employee> cq =
                    cb.createQuery(Employee.class);

            Root<Employee> root = cq.from(Employee.class);

            // Create a subquery to find the maximum salary.
            Subquery<BigDecimal> subquery =
                    cq.subquery(BigDecimal.class);

            Root<Employee> subRoot =
                    subquery.from(Employee.class);

            subquery.select(
                    cb.max(subRoot.<BigDecimal>get("salary"))
            );

            // Find employees earning the maximum salary.
            cq.select(root)
              .where(
                      cb.equal(
                              root.get("salary"),
                              subquery
                      )
              );

            List<Employee> employees =
                    em.createQuery(cq).getResultList();

            employees.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 25. EXISTS SUBQUERY
    // --------------------------------------------------

    public static void existsSubquery() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Department> cq =
                    cb.createQuery(Department.class);

            Root<Department> root =
                    cq.from(Department.class);

            Subquery<Integer> subquery =
                    cq.subquery(Integer.class);

            Root<Employee> employee =
                    subquery.from(Employee.class);

            subquery.select(cb.literal(1));

            subquery.where(
                    cb.equal(
                            employee.get("department"),
                            root
                    )
            );

            cq.select(root)
              .where(cb.exists(subquery));

            List<Department> departments =
                    em.createQuery(cq).getResultList();

            departments.forEach(System.out::println);

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 26. CASE EXPRESSION
    // --------------------------------------------------

    public static void caseExpression() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Tuple> cq =
                    cb.createTupleQuery();

            Root<Employee> root =
                    cq.from(Employee.class);

            CriteriaBuilder.Case<String> salaryCategory =
                    cb.selectCase();

            Expression<String> category =
                    salaryCategory
                            .when(
                                    cb.ge(
                                            root.<BigDecimal>get("salary"),
                                            new BigDecimal("60000")
                                    ),
                                    "HIGH"
                            )
                            .when(
                                    cb.ge(
                                            root.<BigDecimal>get("salary"),
                                            new BigDecimal("30000")
                                    ),
                                    "MEDIUM"
                            )
                            .otherwise("LOW");

            cq.multiselect(
                    root.get("name").alias("employeeName"),
                    category.alias("salaryCategory")
            );

            List<Tuple> results =
                    em.createQuery(cq).getResultList();

            for (Tuple tuple : results) {
                System.out.println(
                        tuple.get("employeeName") +
                        " : " +
                        tuple.get("salaryCategory")
                );
            }

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 27. STRING FUNCTIONS
    // --------------------------------------------------

    public static void stringFunctions() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Tuple> cq =
                    cb.createTupleQuery();

            Root<Employee> root =
                    cq.from(Employee.class);

            cq.multiselect(
                    cb.upper(root.<String>get("name"))
                            .alias("upperName"),

                    cb.lower(root.<String>get("email"))
                            .alias("lowerEmail"),

                    cb.length(root.<String>get("name"))
                            .alias("nameLength")
            );

            List<Tuple> results =
                    em.createQuery(cq).getResultList();

            for (Tuple tuple : results) {
                System.out.println(
                        "Name: " + tuple.get("upperName") +
                        ", Email: " + tuple.get("lowerEmail") +
                        ", Length: " + tuple.get("nameLength")
                );
            }

        } finally {
            em.close();
        }
    }

    // --------------------------------------------------
    // 28. CRITERIA UPDATE
    // --------------------------------------------------

    public static void updateEmployeeSalary() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaUpdate<Employee> update =
                    cb.createCriteriaUpdate(Employee.class);

            Root<Employee> root = update.from(Employee.class);

            update.set(
                    root.<BigDecimal>get("salary"),
                    new BigDecimal("75000")
            );

            update.where(
                    cb.equal(root.get("id"), 1L)
            );

            int updatedRows =
                    em.createQuery(update).executeUpdate();

            transaction.commit();

            System.out.println("Updated rows: " + updatedRows);

        } catch (Exception exception) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            exception.printStackTrace();

        } finally {
            em.clear();
            em.close();
        }
    }

    // --------------------------------------------------
    // 29. CRITERIA DELETE
    // --------------------------------------------------

    public static void deleteEmployee() {

        EntityManager em = JPAUtil.getSessionFactory().openSession();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaDelete<Employee> delete =
                    cb.createCriteriaDelete(Employee.class);

            Root<Employee> root = delete.from(Employee.class);

            delete.where(
                    cb.equal(root.get("id"), 1L)
            );

            int deletedRows =
                    em.createQuery(delete).executeUpdate();

            transaction.commit();

            System.out.println("Deleted rows: " + deletedRows);

        } catch (Exception exception) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            exception.printStackTrace();

        } finally {
            em.clear();
            em.close();
        }
    }
}
