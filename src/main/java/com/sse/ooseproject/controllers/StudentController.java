package com.sse.ooseproject.controllers;

import com.sse.ooseproject.exceptions.StudentValidateException;
import com.sse.ooseproject.models.*;
import com.sse.ooseproject.repositories.CourseRepository;
import com.sse.ooseproject.repositories.EnrollmentRepository;
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
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, InstituteRepository instituteRepository, EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {

        this.studentRepository = studentRepository;
        this.instituteRepository = instituteRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/students")
    public String students(Model model, @RequestParam(value = "sort_by", defaultValue = "matNr", required = false) String sort_by,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sort_asc) {

        List<Student> studentsSorted = Collections.emptyList();
        if (sort_asc && Objects.equals(sort_by, "matNr")) {
            studentsSorted = studentRepository.findByOrderByMatNrAsc();
        }
        if (sort_asc && Objects.equals(sort_by, "lastName")) {
            studentsSorted = studentRepository.findByOrderByLastNameAsc();
        }
        if (sort_asc && Objects.equals(sort_by, "firstName")) {
            studentsSorted = studentRepository.findByOrderByFirstNameAsc();
        }
        if (sort_asc && Objects.equals(sort_by, "studySubject")) {
            studentsSorted = studentRepository.findByOrderByStudySubjectAsc();
        }
        if (!sort_asc && Objects.equals(sort_by, "matNr")) {
            studentsSorted = studentRepository.findByOrderByMatNrDesc();
        }
        if (!sort_asc && Objects.equals(sort_by, "lastName")) {
            studentsSorted = studentRepository.findByOrderByLastNameDesc();
        }
        if (!sort_asc && Objects.equals(sort_by, "firstName")) {
            studentsSorted = studentRepository.findByOrderByFirstNameDesc();
        }
        if (!sort_asc && Objects.equals(sort_by, "studySubject")) {
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
    public String newStudent(Model model, @ModelAttribute("student") Student student) {

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
        if (isValid) {
            studentRepository.save(student);
        }

        model.addAttribute("student", new Student());
        model.addAttribute("page_type", "new");
        model.addAttribute("study_subjects", getStudySubjects());
        model.addAttribute("message_type", messageType);
        model.addAttribute("message", message);

        return "edit_student";
    }

    @GetMapping("/student/edit")
    public String editStudent(Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("student", studentRepository.findStudentById(student.getId()));
        model.addAttribute("page_type", "edit");
        model.addAttribute("study_subjects", getStudySubjects());
        return "edit_student";
    }

    @PostMapping("/student/edit")
    public String editPostStudent(Model model, @ModelAttribute("student") Student student) {

        StudentValidator studentValidator = new StudentValidator(studentRepository, instituteRepository);
        boolean isValid;
        String message = "The student was updated successful.";
        try {
            isValid = studentValidator.validateStudent(student);
        } catch (StudentValidateException sve) {
            isValid = false;
            message = sve.getMessage();
        }
        String messageType = isValid ? "success" : "error";
        if (isValid) {
            studentRepository.save(student);
        }

        model.addAttribute("student", new Student());
        model.addAttribute("page_type", "edit");
        model.addAttribute("study_subjects", getStudySubjects());
        model.addAttribute("message_type", messageType);
        model.addAttribute("message", message);

        return "edit_student";
    }

    @GetMapping("/student/enroll")
    public String addEnrollment(Model model, @ModelAttribute("id") long id, @ModelAttribute("semester") String semester) {

        Student student = studentRepository.findStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("enrollments", enrollmentRepository.findAllBySemester(semester));
        model.addAttribute("semester", semester);

        //find all enrollments to the ID
        List<Enrollment> enrollments = enrollmentRepository.findAllByStudent(student);
        List<Course> courses = new ArrayList<>();
        //get for every ID the fitting course
        //enrollments.forEach(e -> courses.add(courseRepository.findById(e.getId().getCourse_id())));

        model.addAttribute("courses", courses);

        return "enrollment";
    }
}
