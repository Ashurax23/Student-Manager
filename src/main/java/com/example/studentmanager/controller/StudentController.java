package com.example.studentmanager.controller;

import com.example.studentmanager.entity.Student;
import com.example.studentmanager.error.StudentInvalidException;
import com.example.studentmanager.error.StudentNotFoundException;
import com.example.studentmanager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentservice;
    @GetMapping("/students")
    public List<Student> fetchStudentList(){
        return studentservice.fetchStudentList();
    }
    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) throws StudentInvalidException {
            return new ResponseEntity<>(studentservice.saveStudent(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) throws StudentNotFoundException {
         studentservice.deleteStudent(id);
    }
    @GetMapping("/students/{id}")
    public Student fetchStudent(@PathVariable("id") Long id) throws StudentNotFoundException {
        return studentservice.fetchStudent(id);
    }
    @GetMapping("/students/dept/{deptname}")
    public List<Student> fetchStudentByDept(@PathVariable("deptname") String dept){
        return studentservice.fetchStudentByDept(dept.toUpperCase());
    }
    @GetMapping("/students/firstname/{name}")
    public List<Student> fetchStudentByName(@PathVariable("name") String name){
        return studentservice.fetchStudentByName(name);
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id,@RequestBody Student student) throws StudentNotFoundException {
        return studentservice.updateStudent(student,id);
    }


}
