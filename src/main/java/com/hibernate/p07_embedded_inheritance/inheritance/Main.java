package com.hibernate.p07_embedded_inheritance.inheritance;


import com.hibernate.p07_embedded_inheritance.embedded.util.HibernateUtil;
import com.hibernate.p07_embedded_inheritance.inheritance.dao.EmployeeDao;
import com.hibernate.p07_embedded_inheritance.inheritance.joined.ContractEmployee;
import com.hibernate.p07_embedded_inheritance.inheritance.mappedsuperclass.MappedPermanentEmployee;
import com.hibernate.p07_embedded_inheritance.inheritance.singletable.PermanentEmployee;

import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDao();

        // =========================================
        // 1. MAPPED SUPERCLASS
        // =========================================


                MappedPermanentEmployee mappedEmployee =
                new MappedPermanentEmployee(
                        "Rahul",
                        "rahul@gmail.com",
                        "IT",
                        60000,
                        50000,
                        "PF101"
                );

        dao.save(mappedEmployee);


        // =========================================
        // 2. SINGLE TABLE
        // =========================================

        PermanentEmployee singleEmployee =
                new PermanentEmployee(
                        "Amit",
                        "amit@gmail.com",
                        "Finance",
                        70000,
                        40000,
                        "PF102"
                );

        dao.save(singleEmployee);


        // =========================================
        // 3. JOINED
        // =========================================

        ContractEmployee joinedEmployee =
                new ContractEmployee(
                        "Vikas",
                        "vikas@gmail.com",
                        "Support",
                        45000,
                        12,
                        "ABC Agency"
                );

        dao.save(joinedEmployee);


        // =========================================
        // 4. TABLE PER CLASS
        // =========================================

        PermanentEmployee tablePerClassEmployee =
                        new PermanentEmployee(
                        "Ravi",
                        "ravi@gmail.com",
                        "Development",
                        20000,
                        6,
                        "XYZ College"
                );

        dao.save(tablePerClassEmployee);


        // =========================================
        // READ EXAMPLE
        // =========================================

        var employee = dao.findById(
                PermanentEmployee.class,
                singleEmployee.getId()
        );

        if (employee != null) {
            System.out.println("Employee found!");
        }

        HibernateUtil.getSessionFactory().close();
    }
}
