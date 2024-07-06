package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
