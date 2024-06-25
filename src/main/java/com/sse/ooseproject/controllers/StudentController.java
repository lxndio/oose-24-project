package com.sse.ooseproject.controllers;

import com.sse.ooseproject.StudentRepository;
import com.sse.ooseproject.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @GetMapping("/students")
    public String students(Model model,
                           @RequestParam(value = "sort_by", defaultValue = "lastName") String sortBy,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sortAsc) {


        List<Student> students = studentRepository.findAll();

        Comparator<Student> comparator;
        switch (sortBy){
            case "firstName":
                comparator = Comparator.comparing(Student::getFirstName);
                break;
            case "matNr":
                comparator = Comparator.comparing(Student::getMatNr);
                break;
            case "studySubject":
                comparator = Comparator.comparing(Student::getStudySubject);
                break;
            default:
                comparator = Comparator.comparing(Student::getLastName);
                break;
        }

        if (!sortAsc) {
            comparator = comparator.reversed();
        }

        List<Student> sortedStudents = students.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        model.addAttribute("students", sortedStudents);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "students";
    }
}
