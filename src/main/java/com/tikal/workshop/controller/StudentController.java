package com.tikal.workshop.controller;

import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Student REST controller
 */
@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Long> add(@RequestBody StudentJson json) {
        return new ResponseEntity<>(studentService.save(json.toEntity()), CREATED);
    }
}
