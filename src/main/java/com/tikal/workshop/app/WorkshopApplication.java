package com.tikal.workshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot workshop application
 * The main starts the boot application
 */
@SpringBootApplication
@ComponentScan({"com.tikal.workshop.controller", "com.tikal.workshop.service"})
public class WorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class);
    }
}
