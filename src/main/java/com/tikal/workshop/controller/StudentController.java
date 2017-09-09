package com.tikal.workshop.controller;

import com.tikal.workshop.json.StudentJson;
import com.tikal.workshop.service.AsyncService;
import com.tikal.workshop.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Student REST controller
 */
@RestController
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {

    @Value("${name}")
    private String defaultName;

    private final StudentService studentService;

    private final AsyncService asyncService;

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(AsyncService asyncService, StudentService studentService) {
        this.asyncService = asyncService;
        this.studentService = studentService;
    }

    @PostConstruct
    private void postConstruct() {
        asyncService.runCounter();
        logger.info("after async");
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Long> add(@RequestBody StudentJson json) {

        if ( json.getName() == null ) {
            json.setName(defaultName);
        }

        return new ResponseEntity<>(studentService.save(json.toEntity()), CREATED);
    }
}
