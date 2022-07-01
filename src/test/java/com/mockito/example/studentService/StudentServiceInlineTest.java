package com.mockito.example.studentService;

import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.NotificationService;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class StudentServiceInlineTest {
    StudentRepository studentRepository = mock(StudentRepository.class);
    StudentService studentService = new StudentService(studentRepository, new NotificationService());

    @Test
    public void testWithMockObject() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").build();
        when(studentRepository.addStudent(student)).thenReturn(student.getId());
        int studentId = studentService.addStudent(student);
        Assertions.assertEquals(student.getId(),studentId);
        verify(studentRepository, times(1)).addStudent(student);
    }
}




