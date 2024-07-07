package com.sse.ooseproject.validation;

import com.sse.ooseproject.exceptions.StudentValidateException;
import com.sse.ooseproject.models.Institute;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.InstituteRepository;
import com.sse.ooseproject.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StudentValidator {
    private final StudentRepository studentRepository;
    private final InstituteRepository instituteRepository;

    public StudentValidator(StudentRepository studentRepository, InstituteRepository instituteRepository) {

        this.studentRepository = studentRepository;
        this.instituteRepository = instituteRepository;
    }

    public boolean validateStudent(Student student) throws StudentValidateException {

        if (student.getFirstName().isEmpty()) {
            throw new StudentValidateException("Es muss ein Vorname eingegeben werden!");
        }

        if (student.getLastName().isEmpty()) {
            throw new StudentValidateException("Es muss ein Nachname eingegeben werden!");
        }

        if (student.getEmail().isEmpty()) {
            throw new StudentValidateException("Es muss eine E-Mail Adresse eingegeben werden!");
        }

        if (student.getMatNr() <= 0) {
            throw new StudentValidateException("Es muss eine Matr. Nr. eingegeben werden!");
        }

        if (studentRepository.findStudentByMatNr(student.getMatNr()) != null) {
            throw new StudentValidateException("Die angegebene Matr. Nr. ist schon vergeben!");
        }

        if(checkIfEmailIsNotValid(student.getEmail())) {
            throw new StudentValidateException("Die E-Mail ist nicht korrekt!");
        }

        if (!getStudySubjects().contains(student.getStudySubject())) {
            throw new StudentValidateException("Dieses Fach gibt es an der Uni nicht!");
        }

        return true;
    }

    ;

    private List<String> getStudySubjects() {
        List<Institute> institutes = instituteRepository.findAllByUniversityId(1);
        List<String> study_subject = new ArrayList<>();
        institutes.forEach(i -> study_subject.add(i.getProvidesStudySubject()));
        return study_subject;
    }

    private boolean checkIfEmailIsNotValid(String email) {
        // Regex von Baeldung geklaut: https://www.baeldung.com/java-email-validation-regex#strict-regular-expression-validation
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return !Pattern.compile(regex).matcher(email).matches();
    }
}
