package com.example.c3_e1.security.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.c3_e1.authenticationProviders.CustomAuthenticationProvider;

@Component
public class CustomAuthManager implements AuthenticationManager{

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider ;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        if(customAuthenticationProvider.supports(authentication.getClass())){
            return customAuthenticationProvider.authenticate(authentication);
        }else{
            throw new BadCredentialsException("Bigger SHit");
        }
    }

}
