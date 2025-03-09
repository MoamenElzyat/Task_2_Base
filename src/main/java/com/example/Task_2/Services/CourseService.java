package com.example.Task_2.Services;

import com.example.Task_2.model.Course;
import com.example.Task_2.model.Student;
import com.example.Task_2.repository.CourseRepository;
import com.example.Task_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByID(Integer id) {
        return courseRepository.findById(id);
    }

    public List<Course> getCoursesByInstructorId(Integer instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }

    public void enrollStudent(Integer courseId, Integer studentId) {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (courseOpt.isPresent() && studentOpt.isPresent()) {
            Course course = courseOpt.get();
            Student student = studentOpt.get();
            course.getStudents().add(student);
            courseRepository.save(course);
        }
    }

    public void unenrollStudent(Integer courseId, Integer studentId) {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (courseOpt.isPresent() && studentOpt.isPresent()) {
            Course course = courseOpt.get();
            Student student = studentOpt.get();
            course.getStudents().remove(student);
            courseRepository.save(course);
        }
    }
}