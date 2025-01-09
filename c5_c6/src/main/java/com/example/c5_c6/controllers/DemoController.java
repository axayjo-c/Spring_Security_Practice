package com.example.c5_c6.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    @GetMapping("/demo")
    public String getMethodName () {
        return "demo";
    }
    @GetMapping("/demo1")
    public String demo1( ) {
        return "demo1";
    }
    

}
