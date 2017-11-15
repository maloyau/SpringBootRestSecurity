package com.serhii.springbootrestsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    private String home() {
        return "Hello";
    }

    @GetMapping(value = "/private")
    private String privateArea() {
        return "Private";
    }

    @GetMapping(value = "/admin")
    private String adminArea() {
        return "Admin";
    }
}
