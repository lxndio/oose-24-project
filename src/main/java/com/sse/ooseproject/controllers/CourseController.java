package com.sse.ooseproject.controllers;

import com.sse.ooseproject.models.Course;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.CourseRepository;
import com.sse.ooseproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String courses(Model model, @RequestParam(value = "sort_by", defaultValue = "id", required = false) String sort_by,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sort_asc) {

        List<Course> coursesSorted = Collections.emptyList();
        if(sort_asc && Objects.equals(sort_by, "id")) {
            coursesSorted = courseRepository.findByOrderByIdAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "name")) {
            coursesSorted = courseRepository.findByOrderByNameAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "chair")) {
            coursesSorted = courseRepository.findByOrderByChairAsc();
        }
        if(!sort_asc && Objects.equals(sort_by, "id")) {
            coursesSorted = courseRepository.findByOrderByIdDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "name")) {
            coursesSorted = courseRepository.findByOrderByNameDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "chair")) {
            coursesSorted = courseRepository.findByOrderByChairDesc();
        }
        System.out.println("Courses");
        System.out.println(coursesSorted);
        coursesSorted.stream().filter(course -> Objects.equals(course.getName(), "Abstract Algebra")).forEach(course -> System.out.println("" + course.getChair() + course.getName() + course.getChair().getId()));

        model.addAttribute("courses", coursesSorted);
        model.addAttribute("sort_asc", sort_asc);
        model.addAttribute("sort_by", sort_by);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "courses";
    }
}
