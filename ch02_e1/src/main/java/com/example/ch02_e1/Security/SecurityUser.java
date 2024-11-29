package com.example.ch02_e1.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ch02_e1.Models.Authority;
import com.example.ch02_e1.Models.User;


public class SecurityUser implements UserDetails{
    
    private User user;
    private List<Authority> authorities;


    public SecurityUser(User user,List<Authority> authorities){
        System.out.println("securityUser " + user.getUsername() + " Created");
        this.authorities = authorities;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return authorities.stream().map(SecurityAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

}
