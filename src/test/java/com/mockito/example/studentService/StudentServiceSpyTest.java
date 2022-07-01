package com.mockito.example.studentService;

import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceSpyTest {
    @Spy
    StudentRepository  studentRepository ;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testWithSpy() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").build();
        int studentId = studentService.addStudent(student);
        Assertions.assertEquals(student.getId(),studentId);
        verify(studentRepository, times(1)).addStudent(student);
        Assertions.assertEquals(student.getName(),studentRepository.getStudent(studentId).getName());

        when(studentRepository.getStudent(studentId)).thenReturn(Student.builder().id(2).name("Student2").age(6).grade("1st").build());
        Assertions.assertEquals( "Student2", studentRepository.getStudent(studentId).getName());
        verify(studentRepository, times(2)).getStudent(studentId);
    }
}




