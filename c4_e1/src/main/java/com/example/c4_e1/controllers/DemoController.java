package com.example.c4_e1.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {
     @GetMapping("/demo")
     public String demo( ) {
         return "demo";
     }
     
}
