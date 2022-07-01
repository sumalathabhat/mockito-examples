package com.mockito.example.service;

import com.mockito.example.configs.Constants;
import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;

import java.util.Locale;

public class StudentService {
    StudentRepository studentRepository;
    NotificationService notificationService;

    public StudentService(StudentRepository studentRepository, NotificationService notificationService){
        this.studentRepository = studentRepository;
        this.notificationService = notificationService;
    }

    public int addStudent(Student student) {
        System.out.println("Add student inside Student service");
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    public void updateStudent(int id, Student student) {
        studentRepository.updateStudent(id, student);
    }

    public void registerStudent(Student student) {
        addStudent(student);
        String email = Constants.adminEmail.toUpperCase(Locale.ROOT);
        notificationService.sendEmail(email,student.getEmail());
    }
}