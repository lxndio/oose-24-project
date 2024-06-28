package com.sse.ooseproject.controllers;

import com.sse.ooseproject.repositories.StudentRepository;
import com.sse.ooseproject.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String students(Model model, @RequestParam(value = "sort_by", defaultValue = "firstName") String sortBy,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sortAsc) {

        Sort.Direction direction = sortAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        List<Student> students = studentRepository.findAll(sort);
        model.addAttribute("students", students);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "students";
    }
}
