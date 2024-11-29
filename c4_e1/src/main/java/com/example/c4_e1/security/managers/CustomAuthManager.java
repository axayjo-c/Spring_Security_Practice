package com.example.c4_e1.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.c4_e1.security.providers.CustomAuthProvider;

public class CustomAuthManager implements AuthenticationManager{
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


     CustomAuthProvider customAuthProvider = new CustomAuthProvider();
  
     if(customAuthProvider.supports(authentication.getClass()))
     return customAuthProvider.authenticate(authentication);
     else{
        throw new BadCredentialsException("in auth manager");
     }
    }

}
