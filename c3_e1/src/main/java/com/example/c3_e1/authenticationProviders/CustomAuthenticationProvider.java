package com.example.c3_e1.authenticationProviders;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.c3_e1.authenticaion.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
    // @Value("${very.very.secret.key}")
    private String key="siuuu";

    @Override
    public Authentication authenticate(Authentication authentication) 
    //throws AuthenticationException 
    {

        var ca = (CustomAuthentication)authentication;//typecasting to get the key.
        String headerKey = ca.getKey();
        if (this.key.equals(headerKey)) {
            CustomAuthentication result = new CustomAuthentication();
            result.setAuthenticaion(true);
            result.setKey(null);
            return result;
        }else{
            throw new BadCredentialsException("Shitt");
        }

     
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);   
    }

}
