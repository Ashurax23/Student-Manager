package com.example.studentmanager.service;

import com.example.studentmanager.entity.Student;
import com.example.studentmanager.error.StudentInvalidException;
import com.example.studentmanager.error.StudentNotFoundException;
import com.example.studentmanager.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentrepo;
    @Override
    public Student saveStudent(Student student) throws StudentInvalidException, DataIntegrityViolationException {

        try{
            return studentrepo.save(student);
        }
        catch (Exception e){
            throw new StudentInvalidException("Student Invalid or Student Already exists with this details");
        }
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentrepo.findAll();
    }

    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException {
        Optional<Student> student= studentrepo.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student not available");
        }
        studentrepo.deleteById(id);
    }

    @Override
    public Student fetchStudent(Long id) throws StudentNotFoundException {
        Optional<Student> student= studentrepo.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student not available");
        }
        return student.get();
    }

    @Override
    public Student updateStudent(Student student,Long id) throws StudentNotFoundException {
        Optional<Student> student1=studentrepo.findById(id);
        if(!student1.isPresent()){
            throw new StudentNotFoundException("Student not available");
        }
        Student studentDB=student1.get();
        if(Objects.nonNull(student.getFirstName())&&"".equalsIgnoreCase(student.getFirstName())){
            studentDB.setFirstName(student.getFirstName());
        }
        if(Objects.nonNull(student.getLastName())&&!"".equalsIgnoreCase(student.getLastName())){
            studentDB.setLastName(student.getLastName());
        }
        if(Objects.nonNull(student.getDept())&&!"".equalsIgnoreCase(student.getDept())){
            studentDB.setDept(student.getDept());
        }
        if(Objects.nonNull(student.getEmailId())&&!"".equalsIgnoreCase(student.getEmailId())){
            studentDB.setEmailId(student.getEmailId());
        }
        if(Objects.nonNull(student.getPhone())&&!"".equalsIgnoreCase(student.getPhone())){
            studentDB.setPhone(student.getPhone());
        }
        if(Objects.nonNull(student.getGuardianName())&&!"".equalsIgnoreCase(student.getGuardianName())){
            studentDB.setGuardianName(student.getGuardianName());
        }
        if(Objects.nonNull(student.getRollNo())&&!"".equalsIgnoreCase(student.getRollNo())){
            studentDB.setRollNo(student.getRollNo());
        }
        return studentrepo.save(studentDB);
    }

    @Override
    public List<Student> fetchStudentByDept(String dept) {
        return studentrepo.findAllByDept(dept);
    }

    @Override
    public List<Student> fetchStudentByName(String name) {
        return studentrepo.findAllByFirstName(name);
    }

}
