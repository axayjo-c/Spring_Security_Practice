package com.example.c3_e1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.c3_e1.security.filters.CustomAuthFilter;

@Configuration
public class SecurityConfig {
    
    @Autowired
    CustomAuthFilter customAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //Adding a filter where the Username...Fitler used to be.
        //authorize...part need not to worry now.
        return httpSecurity.addFilterAt(customAuthFilter, UsernamePasswordAuthenticationFilter.class)
                            .authorizeRequests().anyRequest().authenticated()
                            .and().build();
    }


}
