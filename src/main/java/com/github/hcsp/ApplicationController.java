package com.github.hcsp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
