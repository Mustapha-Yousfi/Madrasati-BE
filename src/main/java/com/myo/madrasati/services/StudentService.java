package com.myo.madrasati.services;

import com.myo.madrasati.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(101, "Yousfi", "Anas"),
            new Student(102, "Ayed", "Saoussen"),
            new Student(103, "Bounezour", "Maysane"),
            new Student(104, "Tahri", "Rabha")
    ));


    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId())
                index = i;
        }
        if (index != -1)
            students.set(index, student);
    }

    public  void removeStudent(int id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id)
                index = i;
        }
        if (index != -1)
            students.remove(index);

    }

    public Student getStudentById(int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst().get();
    }
}
