package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Course;
import com.sse.ooseproject.models.Enrollment;
import com.sse.ooseproject.models.EnrollmentId;
import com.sse.ooseproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
    void deleteEnrollmentByCourseAndStudent(Course course, Student student);
    List<Enrollment> findAllBySemester(String semester);
    List<Enrollment> findAllByStudent(Student student);
}
