package com.example.Task_2.Services;

import com.example.Task_2.model.Instructor;
import com.example.Task_2.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // ✅ 1️⃣ جلب جميع المدرسين
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // ✅ 2️⃣ البحث عن مدرس بواسطة الـ ID
    public Optional<Instructor> getInstructorByID(Integer id) {
        return instructorRepository.findById(id);
    }

    // ✅ 3️⃣ البحث عن مدرس بواسطة البريد الإلكتروني
    public Instructor getInstructorByEmail(String email) {
        return instructorRepository.findInstructorByEmail(email);
    }
}