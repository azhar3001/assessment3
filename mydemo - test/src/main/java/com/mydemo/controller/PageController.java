package com.mydemo.controller;

import com.mydemo.model.entity.Student;
import com.mydemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@AllArgsConstructor
public class PageController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "studentList";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent2(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/editStudent")
    public String editStudent(@RequestParam("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }



}
