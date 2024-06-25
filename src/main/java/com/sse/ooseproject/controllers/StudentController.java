package com.sse.ooseproject.controllers;

import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String students(Model model, @RequestParam(value = "sort_by", defaultValue = "matNr", required = false) String sort_by,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sort_asc) {

        List<Student> studentsSorted = Collections.emptyList();
        if(sort_asc && Objects.equals(sort_by, "matNr")) {
            studentsSorted = studentRepository.findByOrderByMatNrAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "lastName")) {
            studentsSorted = studentRepository.findByOrderByLastNameAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "firstName")) {
            studentsSorted = studentRepository.findByOrderByFirstNameAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "studySubject")) {
            studentsSorted = studentRepository.findByOrderByStudySubjectAsc();
        }
        if(!sort_asc && Objects.equals(sort_by, "matNr")) {
            studentsSorted = studentRepository.findByOrderByMatNrDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "lastName")) {
            studentsSorted = studentRepository.findByOrderByLastNameDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "firstName")) {
            studentsSorted = studentRepository.findByOrderByFirstNameDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "studySubject")) {
            studentsSorted = studentRepository.findByOrderByStudySubjectDesc();
        }

        model.addAttribute("students", studentsSorted);
        model.addAttribute("sort_asc", sort_asc);
        model.addAttribute("sort_by", sort_by);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "students";
    }
}
