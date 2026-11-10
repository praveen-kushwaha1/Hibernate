package com.hibernate.p05_identifier_generation.idclass.key;



import com.hibernate.p05_identifier_generation.idclass.entity.CourseEnrollmentId;
import jakarta.persistence.*;

@Entity
@Table(name = "course_enrollments")
@IdClass(CourseEnrollmentId.class)
public class CourseEnrollment {

    // These fields together form the primary key.
    @Id
    private Long studentId;

    @Id
    private Long courseId;

    private String enrollmentStatus;

    public CourseEnrollment() {
    }

    public CourseEnrollment(
            Long studentId,
            Long courseId,
            String enrollmentStatus) {

        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentStatus = enrollmentStatus;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
