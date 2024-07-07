package com.sse.ooseproject.controllers;

import com.sse.ooseproject.exceptions.StudentValidateException;
import com.sse.ooseproject.models.Institute;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.InstituteRepository;
import com.sse.ooseproject.repositories.StudentRepository;
import com.sse.ooseproject.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final InstituteRepository instituteRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, InstituteRepository instituteRepository) {

        this.studentRepository = studentRepository;
        this.instituteRepository = instituteRepository;
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

    @GetMapping("/student/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("page_type", "new");
        model.addAttribute("study_subjects", getStudySubjects());
        return "edit_student";
    }

    private List<String> getStudySubjects() {
        List<Institute> institutes = instituteRepository.findAllByUniversityId(1);
        List<String> study_subject = new ArrayList<>();
        institutes.forEach(i -> study_subject.add(i.getProvidesStudySubject()));
        return study_subject;
    }

    @PostMapping("/student/new")
    public String newStudent(Model model, @ModelAttribute("student")Student student) {

        StudentValidator studentValidator = new StudentValidator(studentRepository, instituteRepository);
        boolean isValid;
        String message = "The creation of the new student was successful.";
        try {
            isValid = studentValidator.validateStudent(student);
        } catch (StudentValidateException sve) {
            isValid = false;
            message = sve.getMessage();
        }
        String messageType = isValid ? "success" : "error";

        model.addAttribute("student", new Student());
        model.addAttribute("page_type", "edit");
        model.addAttribute("study_subjects", getStudySubjects());
        model.addAttribute("message_type", messageType);
        model.addAttribute("message", message);

        return "edit_student";
    }
}
