package com.hibernate.p07_embedded_inheritance.inheritance.singletable;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PERMANENT")
public class PermanentEmployee extends Employee {

    private double bonus;
    private String pfNumber;

    public PermanentEmployee() {
    }

    public PermanentEmployee(String name, String email,
                            String department, double salary,
                            double bonus, String pfNumber) {

        super(name, email, department, salary);

        this.bonus = bonus;
        this.pfNumber = pfNumber;
    }
}
