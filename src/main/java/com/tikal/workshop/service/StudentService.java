package com.tikal.workshop.service;

import com.tikal.workshop.entity.Student;
import com.tikal.workshop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Long save(Student student) {
        return 123L;
    }
}
