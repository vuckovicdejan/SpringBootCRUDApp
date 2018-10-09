package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/index")
    public String listAllStudents(Model model) {

        List<Student> students = studentService.getStudents();

        model.addAttribute("student", students);

        return "index";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Model model) {

        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @RequestMapping("index/{id}/delete")
    public String deleteStudent(@PathVariable String id){

        studentService.deleteById(Long.valueOf(id));

        return "redirect:/index";
    }

    @PostMapping (value = "/save")
    public String save(@ModelAttribute("student") Student student) {

        studentService.save(student);

        return "redirect:/index";
    }

    @RequestMapping("/index/{id}/update")
    public String update(@PathVariable String id, Model model){

        model.addAttribute("student", studentService.getSudentById(Long.valueOf(id)));

        return "addstudent";
    }

    @RequestMapping("/index/{id}")
    public String getStudentById(@PathVariable String id, Model model) {

        model.addAttribute("student", studentService.getSudentById(new Long(id)));

        return "studentid";
    }

}
