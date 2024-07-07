package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Course;
import com.sse.ooseproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByOrderByIdAsc();
    List<Course> findByOrderByNameAsc();
    List<Course> findByOrderByChairAsc();
    List<Course> findByOrderByIdDesc();
    List<Course> findByOrderByNameDesc();
    List<Course> findByOrderByChairDesc();
}
