package com.example.studentmanager.repository;

import com.example.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findAllByDept(String dept);

    List<Student> findAllByFirstName(String name);
}
