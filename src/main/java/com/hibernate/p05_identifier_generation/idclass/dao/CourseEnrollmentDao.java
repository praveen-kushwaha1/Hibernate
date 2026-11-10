package com.hibernate.p05_identifier_generation.idclass.dao;


import com.hibernate.p05_identifier_generation.common.GenericDao;
import com.hibernate.p05_identifier_generation.idclass.entity.CourseEnrollmentId;
import com.hibernate.p05_identifier_generation.idclass.key.CourseEnrollment;

public class CourseEnrollmentDao
        extends GenericDao<CourseEnrollment, CourseEnrollmentId> {

    public CourseEnrollmentDao() {
        super(CourseEnrollment.class);
    }
}