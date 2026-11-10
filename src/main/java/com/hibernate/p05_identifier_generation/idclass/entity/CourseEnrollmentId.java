package com.hibernate.p05_identifier_generation.idclass.entity;

import java.io.Serializable;
import java.util.Objects;

public class CourseEnrollmentId implements Serializable {

    private Long studentId;

    private Long courseId;

    public CourseEnrollmentId() {
    }

    public CourseEnrollmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CourseEnrollmentId)) {
            return false;
        }

        CourseEnrollmentId other = (CourseEnrollmentId) obj;

        return Objects.equals(studentId, other.studentId)
                && Objects.equals(courseId, other.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
