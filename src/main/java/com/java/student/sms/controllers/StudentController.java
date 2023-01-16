package com.java.student.sms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/api/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
