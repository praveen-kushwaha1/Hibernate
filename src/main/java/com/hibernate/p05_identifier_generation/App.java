package com.hibernate.p05_identifier_generation;


import com.hibernate.p05_identifier_generation.embeddedid.dao.EmployeeDao;
import com.hibernate.p05_identifier_generation.embeddedid.entity.Employee;
import com.hibernate.p05_identifier_generation.embeddedid.key.EmployeeId;
import com.hibernate.p05_identifier_generation.idclass.dao.CourseEnrollmentDao;
import com.hibernate.p05_identifier_generation.idclass.entity.CourseEnrollmentId;
import com.hibernate.p05_identifier_generation.idclass.key.CourseEnrollment;
import com.hibernate.p05_identifier_generation.identity.dao.IdentityStudentDao;
import com.hibernate.p05_identifier_generation.identity.entity.IdentityStudent;
import com.hibernate.p05_identifier_generation.sequence.dao.SequenceStudentDao;
import com.hibernate.p05_identifier_generation.sequence.entity.SequenceStudent;
import com.hibernate.p05_identifier_generation.zconfig.HibernateUtil;

public class App {

    public static void main(String[] args) {

        try {


            // 2. IDENTITY STRATEGY
            identityCrud();

            // 3. SEQUENCE STRATEGY
            sequenceCrud();



            // 6. EMBEDDED ID STRATEGY
            embeddedIdCrud();

            // 7. ID CLASS STRATEGY
            idClassCrud();

        } finally {

            // Close SessionFactory after all operations.
            HibernateUtil.shutdown();
        }
    }


    // Identity ID CRUD
    private static void identityCrud() {

        System.out.println("\n===== IDENTITY STRATEGY =====");

        IdentityStudentDao dao = new IdentityStudentDao();

        IdentityStudent student =
                new IdentityStudent("Rahul", "rahul@gmail.com");

        dao.save(student);

        Long id = student.getId();

        System.out.println("Generated ID: " + id);

        System.out.println(dao.findById(id).getName());

        student.setName("Rahul Kumar");
        dao.update(student);

        dao.delete(id);
    }

    // Sequence ID CRUD
    private static void sequenceCrud() {

        System.out.println("\n===== SEQUENCE STRATEGY =====");

        SequenceStudentDao dao = new SequenceStudentDao();

        SequenceStudent student =
                new SequenceStudent("Amit", "amit@gmail.com");

        dao.save(student);

        Long id = student.getId();

        System.out.println("Generated ID: " + id);

        System.out.println(dao.findById(id).getName());

        student.setName("Amit Kumar");
        dao.update(student);

        dao.delete(id);
    }

    // Embedded ID CRUD
    private static void embeddedIdCrud() {

        System.out.println("\n===== EMBEDDED ID STRATEGY =====");

        EmployeeDao dao = new EmployeeDao();

        EmployeeId id = new EmployeeId(101L, 10L);

        Employee employee =
                new Employee(id, "Praveen", "praveen@gmail.com");

        dao.save(employee);

        System.out.println(dao.findById(id).getName());

        employee.setName("Praveen Kushwaha");
        dao.update(employee);

        dao.delete(id);
    }

    // IdClass CRUD
    private static void idClassCrud() {

        System.out.println("\n===== ID CLASS STRATEGY =====");

        CourseEnrollmentDao dao = new CourseEnrollmentDao();

        CourseEnrollment enrollment =
                new CourseEnrollment(101L, 501L, "ACTIVE");

        dao.save(enrollment);

        CourseEnrollmentId id =
                new CourseEnrollmentId(101L, 501L);

        System.out.println(
                dao.findById(id).getEnrollmentStatus()
        );

        enrollment.setEnrollmentStatus("COMPLETED");
        dao.update(enrollment);

        dao.delete(id);
    }
}
