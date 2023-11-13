package com.example.studentmanager.service;

import com.example.studentmanager.entity.Student;
import com.example.studentmanager.error.StudentInvalidException;
import com.example.studentmanager.error.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student) throws StudentInvalidException;

    List<Student> fetchStudentList();

    void deleteStudent(Long id) throws StudentNotFoundException;

    Student fetchStudent(Long id) throws StudentNotFoundException;

    Student updateStudent(Student student,Long id) throws StudentNotFoundException;

    List<Student> fetchStudentByDept(String dept);

    List<Student> fetchStudentByName(String name);
}
