package com.myo.madrasati.repository;

import com.myo.madrasati.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("SELECT p FROM Student p WHERE " +
            "p.firstName LIKE :keyword OR " +
            "p.lastName LIKE :keyword")
    List<Student> search(String keyword) ;
}
