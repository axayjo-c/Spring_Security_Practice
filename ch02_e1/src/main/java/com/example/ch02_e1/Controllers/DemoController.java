package com.example.ch02_e1.Controllers;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String helloString() {

        var u = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(u.getName());
        u.getAuthorities().forEach((a)->System.out.println(a.getAuthority()));
        return "hello";
    }
    
}
