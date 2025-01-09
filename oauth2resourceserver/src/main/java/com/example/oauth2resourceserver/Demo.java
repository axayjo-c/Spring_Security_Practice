package com.example.oauth2resourceserver;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Demo {

        @GetMapping("/hello")
        public String getMethodName() {
            return new String("hello?");
        }
        
}
