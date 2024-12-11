package com.mydemo.controller;

import com.mydemo.model.entity.Student;
import com.mydemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/listAll")
    public List<Student> listAll() {
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        return studentService.saveOrUpdateStudent(student);
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(Integer studentID) {
        return studentService.deleteStudent(studentID);
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(Integer studentID) {
        return studentService.getStudentById(studentID);
    }


}
