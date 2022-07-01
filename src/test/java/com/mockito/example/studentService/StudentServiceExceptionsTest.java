package com.mockito.example.studentService;

import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceExceptionsTest {
    @Mock
    StudentRepository  studentRepository ;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testWithException() {
        when(studentRepository.getStudent(5)).thenThrow(new IllegalArgumentException());
        assertThrows(IllegalArgumentException.class, () -> studentService.getStudent(5));
        verify(studentRepository).getStudent(5);
    }
}