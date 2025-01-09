package com.example.oauth2resourceserver.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "demo::";
    }
}
