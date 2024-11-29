package com.example.ch02_e1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ch02_e1.Repos.UserRepo;
import com.example.ch02_e1.Security.SecurityUser;
@Service
public class JdbcUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserAuthorityManager userAuthorityManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.err.println("hello " + username);
       var u = this.userRepo.findUserByUsername(username);
       System.err.println("hihi" + u.getUsername() + " " + u.getPassword());

       return new SecurityUser(u,userAuthorityManager.getAuthorities(u.getId()));
    }
    
}
