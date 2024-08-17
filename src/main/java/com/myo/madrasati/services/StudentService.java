package com.myo.madrasati.services;

import com.myo.madrasati.models.Student;
import com.myo.madrasati.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

//    List<Student> students = new ArrayList<>(Arrays.asList(
//            new Student(101, "Yousfi", "Anas"),
//            new Student(102, "Ayed", "Saoussen"),
//            new Student(103, "Bounezour", "Maysane"),
//            new Student(104, "Tahri", "Rabha")
//    ));


    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public void updateStudent(Student student) {

        if (studentRepo.existsById(student.getId()))
            studentRepo.save(student);
    }

    public  void removeStudent(int id) {
        studentRepo.deleteById(id);

    }

    public Student getStudentById(int studentId) {
        return studentRepo.findById(studentId).get();
    }
}
