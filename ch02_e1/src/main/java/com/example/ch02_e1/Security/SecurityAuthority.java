package com.example.ch02_e1.Security;

import org.springframework.security.core.GrantedAuthority;

import com.example.ch02_e1.Models.Authority;

public class SecurityAuthority implements GrantedAuthority{

    private final Authority authority;

    SecurityAuthority(Authority a){
        this.authority = a;
    }
    
    @Override
    public String getAuthority() {
        return authority.getName();
    }

}
