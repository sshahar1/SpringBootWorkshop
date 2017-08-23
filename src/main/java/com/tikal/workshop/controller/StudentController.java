package com.tikal.workshop.controller;

import com.tikal.workshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {

    @Autowired
    private StudentService studentService;
}
