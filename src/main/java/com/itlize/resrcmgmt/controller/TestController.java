package com.itlize.resrcmgmt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/admin") 
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Admin";
    }
}
