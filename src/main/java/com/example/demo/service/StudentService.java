package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student>getStudents();
    public Student getSudentById(Long id);
//    public Student addStudent();
    public void deleteById(Long id);
    public Student save(Student student);

}
