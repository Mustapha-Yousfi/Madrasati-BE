package com.myo.madrasati.controller;

import com.myo.madrasati.model.Student;
import com.myo.madrasati.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void removeStudent(@PathVariable int studentId) {
        studentService.removeStudent(studentId);
    }
}
