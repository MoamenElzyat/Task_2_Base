package com.example.Task_2.controller;

import com.example.Task_2.Services.CourseService;
import com.example.Task_2.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{instructorId}")
    public List<Course> getCoursesByInstructorId(@PathVariable Integer instructorId) {
        return courseService.getCoursesByInstructorId(instructorId);
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<String> enrollStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) {
        courseService.enrollStudent(courseId, studentId);
        return ResponseEntity.ok("Student enrolled successfully in course ID: " + courseId);
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<String> unenrollStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) {
        courseService.unenrollStudent(courseId, studentId);
        return ResponseEntity.ok("Student unenrolled successfully from course ID: " + courseId);
    }
}