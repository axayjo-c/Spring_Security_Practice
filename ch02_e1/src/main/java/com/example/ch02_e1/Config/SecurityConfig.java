package com.example.ch02_e1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig {
    @Bean
    PasswordEncoder psw(){
        return NoOpPasswordEncoder.getInstance();
    }
}
