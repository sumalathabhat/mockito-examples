package com.mockito.example.studentService;

import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import util.StudentMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceArgumentMatcherTest {

    @Mock
    StudentRepository studentRepository ;


    @InjectMocks
    StudentService studentService;



    @Test
    public void testWithGenericArgumentMatcher() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").email("student1@xyz.com").build();
        doNothing().when(studentRepository).updateStudent(anyInt(),any(Student.class));
        studentService.updateStudent(1,student);
        verify(studentRepository, times(1)).updateStudent(anyInt(),any(Student.class));
    }

    @Test
    public void testWithCustomArgumentMatcher() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").email("student1@xyz.com").build();
        doNothing().when(studentRepository).updateStudent(anyInt(),argThat(new StudentMatcher(student)));
        studentService.updateStudent(1,student);
        verify(studentRepository, times(1)).updateStudent(anyInt(),argThat(new StudentMatcher(student)));
    }
}
