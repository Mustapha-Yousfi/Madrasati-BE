package com.myo.madrasati.controller;

import com.myo.madrasati.model.Student;
import com.myo.madrasati.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {

        return ResponseEntity
                .ok()
                .body(studentService.getStudents());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null)
            return ResponseEntity
                    .ok()
                    .body(student);
        else
            return ResponseEntity
                    .notFound()
                    .build();
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

    @GetMapping("/students/search")
    public ResponseEntity<List<Student>> search(@RequestParam String keyword) {
        System.out.println("Keyword = " + keyword);
        List<Student> students = studentService.searchStudents(keyword);
        return ResponseEntity.ok().body(students);
    }
}
