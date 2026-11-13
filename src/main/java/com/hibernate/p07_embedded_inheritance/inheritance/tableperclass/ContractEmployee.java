package com.hibernate.p07_embedded_inheritance.inheritance.tableperclass;

import jakarta.persistence.*;

@Entity
@Table(name = "tpc_contract_employee")
public class ContractEmployee extends Employee {

    private int contractDurationMonths;
    private String agencyName;

    public ContractEmployee() {
    }

    public ContractEmployee(String name, String email,
                           String department, double salary,
                           int contractDurationMonths,
                           String agencyName) {

        super(name, email, department, salary);

        this.contractDurationMonths = contractDurationMonths;
        this.agencyName = agencyName;
    }
}
