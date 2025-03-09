package com.example.Task_2.controller;

import com.example.Task_2.model.Instructor;
import com.example.Task_2.Services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Instructor> getInstructorByEmail(@PathVariable String email) {
        Instructor instructor = instructorService.getInstructorByEmail(email);
        return instructor != null ? ResponseEntity.ok(instructor) : ResponseEntity.notFound().build();
    }
}