package com.example.c4_e1.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.c4_e1.security.ApiKeyAuthentication;
import com.example.c4_e1.security.managers.CustomAuthManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyFilter extends OncePerRequestFilter{

    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            String requestKey = request.getHeader("api-key");
           

            if("null".equals(requestKey) || requestKey == null){ 
                System.out.println("hell" + requestKey);
                filterChain.doFilter(request, response);//proceeding step.
            }else{

            var a = new  ApiKeyAuthentication();
            a.setAuthenticated(false);
            a.setkey(requestKey);
            
            CustomAuthManager customAuthManager = new CustomAuthManager();
             
            var b = customAuthManager.authenticate(a);

            if(b.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(b);
                filterChain.doFilter(request, response);
                
            }else{
                throw new BadCredentialsException("shit");
            }
        }
            
                
    }


    
}
