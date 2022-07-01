package com.mockito.example.studentService;

import com.mockito.example.configs.Constants;
import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.NotificationService;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceCaptorTest {
    @Mock
    StudentRepository  studentRepository ;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    StudentService studentService;

    @Captor
    ArgumentCaptor<String> studentArgumentCaptor;



    @Test
    public void testWithCaptor() {
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").email("student1@xyz.com").build();
        when(studentRepository.addStudent(student)).thenReturn(student.getId());
        studentService.registerStudent(student);
        verify(notificationService, times(1)).sendEmail(studentArgumentCaptor.capture(),eq(student.getEmail()));
        var adminEmail = studentArgumentCaptor.getValue();
        Assertions.assertEquals(Constants.adminEmail.toUpperCase(Locale.ROOT),adminEmail);
    }

}