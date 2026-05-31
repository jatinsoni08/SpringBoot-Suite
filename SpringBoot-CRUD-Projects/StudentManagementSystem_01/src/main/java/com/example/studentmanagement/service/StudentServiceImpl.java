package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Integer id, Student student) {

        Student dbStudent = repository.findById(id).orElse(null);

        if(dbStudent != null) {
            dbStudent.setName(student.getName());
            dbStudent.setCourse(student.getCourse());
            dbStudent.setFee(student.getFee());

            return repository.save(dbStudent);
        }

        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}