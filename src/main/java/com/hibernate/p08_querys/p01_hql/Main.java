package com.hibernate.p08_querys.p01_hql;



import com.hibernate.p08_querys.p01_hql.dto.EmployeeDTO;
import com.hibernate.p08_querys.p01_hql.entity.Employee;
import com.hibernate.p08_querys.p01_hql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            // 01. Basic SELECT queries
            basicSelect(session);

            // 02. WHERE conditions
            whereConditions(session);

            // 03. Sorting and grouping
            sortingAndGrouping(session);

            // 04. Aggregate functions
            aggregateFunctions(session);

            // 05. JOIN queries
            joins(session);

            // 06. Subqueries
            subqueries(session);

            // 07. DTO projections
            projection(session);

            // 08. Advanced HQL
            advancedHql(session);

            // 09. Pagination
            pagination(session);

            // 10. Bulk operations
            // Execute separately because these modify database records.
            // bulkOperations(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    // =====================================================
    // 01. BASIC SELECT QUERIES
    // =====================================================

    public static void basicSelect(Session session) {

        // Select all employees
        List<Employee> employees = session.createQuery(
                "FROM Employee", Employee.class)
                .getResultList();

        // Select using SELECT keyword
        List<Employee> allEmployees = session.createQuery(
                "SELECT e FROM Employee e", Employee.class)
                .getResultList();

        // Find employee by ID
        Employee employee = session.createQuery(
                "FROM Employee e WHERE e.id = :id",
                Employee.class)
                .setParameter("id", 1L)
                .uniqueResult();

        // Select specific columns
        List<Object[]> results = session.createQuery(
                "SELECT e.name, e.salary FROM Employee e",
                Object[].class)
                .getResultList();

        // DISTINCT
        List<String> cities = session.createQuery(
                "SELECT DISTINCT e.city FROM Employee e",
                String.class)
                .getResultList();

        System.out.println("Basic SELECT completed");
    }

    // =====================================================
    // 02. WHERE CONDITIONS AND OPERATORS
    // =====================================================

    public static void whereConditions(Session session) {

        // Equal
        List<Employee> equal = session.createQuery(
                "FROM Employee e WHERE e.city = :city",
                Employee.class)
                .setParameter("city", "Bangalore")
                .getResultList();

        // Greater than
        List<Employee> greater = session.createQuery(
                "FROM Employee e WHERE e.salary > :salary",
                Employee.class)
                .setParameter("salary", new BigDecimal("60000"))
                .getResultList();

        // AND
        List<Employee> and = session.createQuery(
                "FROM Employee e WHERE e.city = :city " +
                "AND e.salary > :salary", Employee.class)
                .setParameter("city", "Bangalore")
                .setParameter("salary", new BigDecimal("50000"))
                .getResultList();

        // OR
        List<Employee> or = session.createQuery(
                "FROM Employee e WHERE e.city = :city1 " +
                "OR e.city = :city2", Employee.class)
                .setParameter("city1", "Noida")
                .setParameter("city2", "Delhi")
                .getResultList();

        // NOT
        List<Employee> not = session.createQuery(
                "FROM Employee e WHERE NOT e.active",
                Employee.class)
                .getResultList();

        // BETWEEN
        List<Employee> between = session.createQuery(
                "FROM Employee e WHERE e.salary BETWEEN :min AND :max",
                Employee.class)
                .setParameter("min", new BigDecimal("50000"))
                .setParameter("max", new BigDecimal("80000"))
                .getResultList();

        // IN
        List<Employee> in = session.createQuery(
                "FROM Employee e WHERE e.city IN :cities",
                Employee.class)
                .setParameterList("cities", List.of("Noida", "Delhi"))
                .getResultList();

        // LIKE
        List<Employee> like = session.createQuery(
                "FROM Employee e WHERE e.name LIKE :name",
                Employee.class)
                .setParameter("name", "P%")
                .getResultList();

        // IS NULL
        List<Employee> isNull = session.createQuery(
                "FROM Employee e WHERE e.department IS NULL",
                Employee.class)
                .getResultList();

        // IS NOT NULL
        List<Employee> isNotNull = session.createQuery(
                "FROM Employee e WHERE e.department IS NOT NULL",
                Employee.class)
                .getResultList();
    }

    // =====================================================
    // 03. ORDER BY, GROUP BY AND HAVING
    // =====================================================

    public static void sortingAndGrouping(Session session) {

        // ASC
        List<Employee> asc = session.createQuery(
                "FROM Employee e ORDER BY e.salary ASC",
                Employee.class).getResultList();

        // DESC
        List<Employee> desc = session.createQuery(
                "FROM Employee e ORDER BY e.salary DESC",
                Employee.class).getResultList();

        // Multiple sorting
        List<Employee> multipleSort = session.createQuery(
                "FROM Employee e ORDER BY e.city ASC, e.salary DESC",
                Employee.class).getResultList();

        // GROUP BY
        List<Object[]> groupBy = session.createQuery(
                "SELECT e.city, COUNT(e.id) FROM Employee e " +
                "GROUP BY e.city", Object[].class)
                .getResultList();

        // HAVING
        List<Object[]> having = session.createQuery(
                "SELECT e.city, COUNT(e.id) FROM Employee e " +
                "GROUP BY e.city HAVING COUNT(e.id) > 1",
                Object[].class).getResultList();
    }

    // =====================================================
    // 04. AGGREGATE FUNCTIONS
    // =====================================================

    public static void aggregateFunctions(Session session) {

        Long count = session.createQuery(
                "SELECT COUNT(e) FROM Employee e",
                Long.class).getSingleResult();

        BigDecimal sum = session.createQuery(
                "SELECT SUM(e.salary) FROM Employee e",
                BigDecimal.class).getSingleResult();

        Double average = session.createQuery(
                "SELECT AVG(e.salary) FROM Employee e",
                Double.class).getSingleResult();

        BigDecimal max = session.createQuery(
                "SELECT MAX(e.salary) FROM Employee e",
                BigDecimal.class).getSingleResult();

        BigDecimal min = session.createQuery(
                "SELECT MIN(e.salary) FROM Employee e",
                BigDecimal.class).getSingleResult();
    }

    // =====================================================
    // 05. JOIN QUERIES
    // =====================================================

    public static void joins(Session session) {

        // INNER JOIN
        List<Employee> innerJoin = session.createQuery(
                "SELECT e FROM Employee e " +
                "JOIN e.department d WHERE d.name = :name",
                Employee.class)
                .setParameter("name", "IT")
                .getResultList();

        // LEFT JOIN
        List<Employee> leftJoin = session.createQuery(
                "SELECT e FROM Employee e LEFT JOIN e.department d",
                Employee.class).getResultList();

        // JOIN FETCH
        List<Employee> fetchJoin = session.createQuery(
                "SELECT e FROM Employee e JOIN FETCH e.department",
                Employee.class).getResultList();

        // LEFT JOIN FETCH
        List<Employee> leftFetchJoin = session.createQuery(
                "SELECT e FROM Employee e LEFT JOIN FETCH e.department",
                Employee.class).getResultList();

        // JOIN with ON
        List<Object[]> onJoin = session.createQuery(
                "SELECT e.name, d.name FROM Employee e " +
                "JOIN e.department d ON d.location = :location",
                Object[].class)
                .setParameter("location", "Bangalore")
                .getResultList();
    }

    // =====================================================
    // 06. SUBQUERIES
    // =====================================================

    public static void subqueries(Session session) {

        // Salary greater than average
        List<Employee> aboveAverage = session.createQuery(
                "FROM Employee e WHERE e.salary > " +
                "(SELECT AVG(e2.salary) FROM Employee e2)",
                Employee.class).getResultList();

        // IN subquery
        List<Employee> inSubquery = session.createQuery(
                "FROM Employee e WHERE e.department.id IN " +
                "(SELECT d.id FROM Department d " +
                "WHERE d.location = :location)",
                Employee.class)
                .setParameter("location", "Bangalore")
                .getResultList();

        // EXISTS
        List<Employee> exists = session.createQuery(
                "FROM Employee e WHERE EXISTS " +
                "(SELECT d.id FROM Department d " +
                "WHERE d.id = e.department.id)",
                Employee.class).getResultList();

        // NOT EXISTS
        List<Employee> notExists = session.createQuery(
                "FROM Employee e WHERE NOT EXISTS " +
                "(SELECT d.id FROM Department d " +
                "WHERE d.id = e.department.id)",
                Employee.class).getResultList();

        // Correlated subquery
        List<Employee> correlated = session.createQuery(
                "FROM Employee e WHERE e.salary > " +
                "(SELECT AVG(e2.salary) FROM Employee e2 " +
                "WHERE e2.department = e.department)",
                Employee.class).getResultList();

        // Department-wise highest salary
        List<Employee> highestSalary = session.createQuery(
                "FROM Employee e WHERE e.salary = " +
                "(SELECT MAX(e2.salary) FROM Employee e2 " +
                "WHERE e2.department = e.department)",
                Employee.class).getResultList();
    }

    // =====================================================
    // 07. DTO PROJECTION
    // =====================================================

    public static void projection(Session session) {

        List<EmployeeDTO> employees = session.createQuery(
                "SELECT new com.hibernate.p08_querys.p01_hql.dto.EmployeeDTO(" +
                "e.name, e.salary, d.name) " +
                "FROM Employee e JOIN e.department d",
                EmployeeDTO.class)
                .getResultList();

        employees.forEach(System.out::println);
    }

    // =====================================================
    // 08. ADVANCED HQL
    // =====================================================

    public static void advancedHql(Session session) {

        // CASE WHEN
        List<Object[]> caseResults = session.createQuery(
                "SELECT e.name, CASE " +
                "WHEN e.salary >= 80000 THEN 'HIGH' " +
                "WHEN e.salary >= 60000 THEN 'MEDIUM' " +
                "ELSE 'LOW' END FROM Employee e",
                Object[].class).getResultList();

        // UPPER
        List<String> upper = session.createQuery(
                "SELECT UPPER(e.name) FROM Employee e",
                String.class).getResultList();

        // LOWER
        List<String> lower = session.createQuery(
                "SELECT LOWER(e.name) FROM Employee e",
                String.class).getResultList();

        // LENGTH
        List<Integer> length = session.createQuery(
                "SELECT LENGTH(e.name) FROM Employee e",
                Integer.class).getResultList();

        // CONCAT
        List<String> concat = session.createQuery(
                "SELECT CONCAT(e.name, ' - ', e.designation) " +
                "FROM Employee e", String.class).getResultList();

        // COALESCE
        List<String> coalesce = session.createQuery(
                "SELECT COALESCE(e.city, 'Unknown') FROM Employee e",
                String.class).getResultList();

        // Collection SIZE
        List<Object[]> size = session.createQuery(
                "SELECT d.name, SIZE(d.employees) FROM Department d",
                Object[].class).getResultList();

        // Named parameter
        List<Employee> named = session.createQuery(
                "FROM Employee e WHERE e.city = :city",
                Employee.class)
                .setParameter("city", "Bangalore")
                .getResultList();

        // Positional parameter
        List<Employee> positional = session.createQuery(
                "FROM Employee e WHERE e.city = ?1",
                Employee.class)
                .setParameter(1, "Bangalore")
                .getResultList();

        // UNION (Hibernate 6+)
        List<String> union = session.createQuery(
                "SELECT e.name FROM Employee e WHERE e.city = 'Noida' " +
                "UNION " +
                "SELECT e.name FROM Employee e WHERE e.city = 'Delhi'",
                String.class).getResultList();

        // Window function (supported Hibernate version/dialect)
        List<Object[]> ranking = session.createQuery(
                "SELECT e.name, e.salary, " +
                "RANK() OVER (ORDER BY e.salary DESC) " +
                "FROM Employee e",
                Object[].class).getResultList();
    }

    // =====================================================
    // 09. PAGINATION
    // =====================================================

    public static void pagination(Session session) {

        int pageNumber = 0;
        int pageSize = 3;

        List<Employee> employees = session.createQuery(
                "FROM Employee e ORDER BY e.id",
                Employee.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        // Top 3 highest-paid employees
        List<Employee> topThree = session.createQuery(
                "FROM Employee e ORDER BY e.salary DESC",
                Employee.class)
                .setMaxResults(3)
                .getResultList();
    }

    // =====================================================
    // 10. BULK OPERATIONS
    // =====================================================

    public static void bulkOperations(Session session) {

        Transaction tx = session.beginTransaction();

        try {

            // UPDATE
            int updated = session.createMutationQuery(
                    "UPDATE Employee e SET e.salary = :salary " +
                    "WHERE e.name = :name")
                    .setParameter("salary", new BigDecimal("95000"))
                    .setParameter("name", "Praveen")
                    .executeUpdate();

            // DELETE
            int deleted = session.createMutationQuery(
                    "DELETE FROM Employee e WHERE e.active = false")
                    .executeUpdate();

            tx.commit();

            System.out.println("Updated: " + updated);
            System.out.println("Deleted: " + deleted);

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;
        }
    }
}
