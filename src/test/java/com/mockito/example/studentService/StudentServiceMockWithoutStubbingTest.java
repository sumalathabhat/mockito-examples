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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceMockWithoutStubbingTest {
    @Mock
    StudentRepository  studentRepository ;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testWithMockWithoutStubbing() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").build();
        int studentId = studentService.addStudent(student);
        Assertions.assertEquals(0,studentId);
        verify(studentRepository, times(1)).addStudent(student);
    }
}