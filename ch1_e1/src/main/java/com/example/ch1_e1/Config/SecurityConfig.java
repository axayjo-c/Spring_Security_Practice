package com.example.ch1_e1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
     UserDetailsService something(){
        var uds = new InMemoryUserDetailsManager();
        UserDetails a1 = User.withUsername("akshay")
                             .password("333")   
                             .authorities("read")   
                             .build();

        uds.createUser(a1);
        return uds;
    }

    @Bean
    PasswordEncoder somethingPassword(){
        return NoOpPasswordEncoder.getInstance();
    }

}
