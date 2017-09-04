package com.tikal.workshop.controller;

import com.tikal.workshop.app.WorkshopApplication;
import com.tikal.workshop.entity.Student;
import com.tikal.workshop.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO: Your test must pass
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = WorkshopApplication.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testPost() throws Exception {

        when(studentService.save(new Student())).thenReturn(123L);
        mockMvc.perform(post("/student/")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(content().string(is("123")));
    }
}