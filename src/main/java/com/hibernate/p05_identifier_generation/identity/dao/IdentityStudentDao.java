package com.hibernate.p05_identifier_generation.identity.dao;


import com.hibernate.p05_identifier_generation.common.GenericDao;
import com.hibernate.p05_identifier_generation.identity.entity.IdentityStudent;

public class IdentityStudentDao extends GenericDao<IdentityStudent, Long> {

    public IdentityStudentDao() {
        super(IdentityStudent.class);
    }
}