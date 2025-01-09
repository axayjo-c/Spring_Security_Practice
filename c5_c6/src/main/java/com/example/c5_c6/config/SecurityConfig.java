package com.example.c5_c6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            return http.httpBasic()
                        .and()
                        .authorizeRequests()
                        .requestMatchers("demo")
                        .access("isAuthenticated() and hasAuthority('write')")
                        // .anyRequest().hasRole("ADMIN")
                        .and()
                        .build();
    } 

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetailsManager uds = new InMemoryUserDetailsManager();

     var u1 =  User.withUsername("bill")
                    .password(passwordEncoder.encode("123"))
                    .authorities("read")
                    .roles("MANAGER")
                    .build();

    var u2 = User.withUsername("john")
                 .password(passwordEncoder.encode("222"))
                 .authorities("write","read")

                 .build();

        uds.createUser(u1);
        uds.createUser(u2);


        return uds;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
