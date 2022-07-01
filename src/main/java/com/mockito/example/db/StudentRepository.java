package com.mockito.example.db;

import com.mockito.example.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepository {
    List<Student> studentList = new ArrayList<>();

    public int addStudent(Student student) {
        studentList.add(student);
        System.out.println("Add student inside Student repository");
        return student.getId();
    }

    public Student getStudent(int id) {
        return studentList.stream().filter(student -> Objects.equals(student.getId(), id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Student not found with given id "+ id));
    }

    public void updateStudent(int id, Student student) {
        System.out.println("Update student");
    }
}