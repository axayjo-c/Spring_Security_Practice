package com.example.ch1_e1.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "hello";
    }
}
