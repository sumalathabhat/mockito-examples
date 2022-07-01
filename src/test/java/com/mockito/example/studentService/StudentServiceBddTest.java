package com.mockito.example.studentService;

import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceBddTest {
    @Mock
    StudentRepository  studentRepository ;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testWithBdd() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").build();
        //given
        given(studentRepository.addStudent(student)).willReturn(student.getId());

        //when
        int studentId = studentService.addStudent(student);

        //then
        Assertions.assertEquals(student.getId(),studentId);
        then(studentRepository).should(times(1)).addStudent(student);
        then(studentRepository).shouldHaveNoMoreInteractions();
    }
}