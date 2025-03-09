package com.example.Task_2.repository;

import com.example.Task_2.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    Instructor findInstructorByEmail(String email);
}