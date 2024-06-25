package com.sse.ooseproject.controllers;

import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        // TODO add functionality.
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
        studentsSorted.stream().filter(student -> student.getId() < 10).forEach(student -> System.out.println(student.getFirstName()));
        System.out.println(studentsSorted.size());
        studentRepository.saveAll(studentsSorted);
        System.out.println("model before");
        System.out.println(model);
        model.addAllAttributes(studentsSorted);
        System.out.println("model after");
        System.out.println(model);
        model.asMap().forEach((student, name) -> System.out.println(student + name));
        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "students";
    }
}
