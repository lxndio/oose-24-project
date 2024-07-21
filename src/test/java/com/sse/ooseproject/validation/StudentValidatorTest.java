package com.sse.ooseproject.validation;

import com.sse.ooseproject.exceptions.StudentValidateException;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.repositories.InstituteRepository;
import com.sse.ooseproject.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentValidatorTest {

    @Mock
    StudentRepository studentRepository;
    @Mock
    InstituteRepository instituteRepository;
    StudentValidator studentValidator;

    @BeforeEach
    void createStudentValidator() {
        studentRepository = Mockito.mock(StudentRepository.class);
        instituteRepository = Mockito.mock(InstituteRepository.class);
        studentValidator = new StudentValidator(studentRepository, instituteRepository);
    }
    @Test
    public void isFirstnameEmpty() {
        Student student = new Student();
        student.setFirstName("");
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Es muss ein Vorname eingegeben werden!");
        }
    }

    @Test
    public void isLastnameEmpty() {
        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("");
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Es muss ein Nachname eingegeben werden!");
        }
    }

    @Test
    public void isEmailEmpty() {
        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("Mustermann");
        student.setEmail("");
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Es muss eine E-Mail Adresse eingegeben werden!");
        }
    }

    @Test
    public void isMatNrGleichNull() {
        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("Mustermann");
        student.setEmail("max.mustermann@example.com");
        student.setMatNr(0);
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Es muss eine Matr. Nr. eingegeben werden!");
        }
    }

    @Test
    public void isStudentInRepository() {
        Mockito.when(studentRepository.findStudentByMatNr(Mockito.anyInt())).thenReturn(new Student());

        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("Mustermann");
        student.setEmail("max.mustermann@example.com");
        student.setMatNr(5390380);
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Die angegebene Matr. Nr. ist schon vergeben!");
        }
    }

    @Test
    public void isEmailNotValid() {
        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("Mustermann");
        student.setEmail("max.mustermann");
        student.setMatNr(1);
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Die E-Mail ist nicht korrekt!");
        }
    }

    @Test
    public void isWrongStudySubject() {
        Student student = new Student();
        student.setFirstName("Max");
        student.setLastName("Mustermann");
        student.setEmail("max.mustermann@example.com");
        student.setMatNr(1);
        student.setStudySubject("Test");
        try {
            studentValidator.validateStudent(student);
        } catch (StudentValidateException e) {
            assertEquals(e.getMessage(), "Dieses Fach gibt es an der Uni nicht!");
        }
    }
}
