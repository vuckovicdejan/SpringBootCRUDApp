package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        studentRepo.findAll().iterator().forEachRemaining(students::add);

        return students;
    }

    @Override
    public Student getSudentById(Long id) {

        Optional<Student> student = studentRepo.findById(id);

        if (!student.isPresent()) {
            throw new RuntimeException("Student not found");
        }

        return student.get();
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student save(Student student) {

        studentRepo.save(student);

        return student;
    }


}
