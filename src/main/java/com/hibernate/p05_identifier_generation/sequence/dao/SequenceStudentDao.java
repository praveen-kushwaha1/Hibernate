package com.hibernate.p05_identifier_generation.sequence.dao;


import com.hibernate.p05_identifier_generation.common.GenericDao;
import com.hibernate.p05_identifier_generation.sequence.entity.SequenceStudent;

public class SequenceStudentDao extends GenericDao<SequenceStudent, Long> {

    public SequenceStudentDao() {
        super(SequenceStudent.class);
    }
}