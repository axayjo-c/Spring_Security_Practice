package com.example.c7_e1.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('read')")
    public String demo(){
        return "dmeo";
    }

}
