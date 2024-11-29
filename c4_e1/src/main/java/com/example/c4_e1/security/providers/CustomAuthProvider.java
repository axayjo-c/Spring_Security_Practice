package com.example.c4_e1.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.c4_e1.security.ApiKeyAuthentication;

public class CustomAuthProvider implements AuthenticationProvider{

    // @Value("${secret.key}")
    private String key = "siuuu";


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication auth = (ApiKeyAuthentication)authentication;
        

        if(auth.getKey().equals(key)){
            auth.setAuthenticated(true);
            return auth;
        }else{
            throw new BadCredentialsException("in authentication provider");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);//if ApiKeyAuthentication class equals given authentication then it supports the authentication;
    }


}
