package com.example.c3_e1.security.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.c3_e1.authenticaion.CustomAuthentication;
import com.example.c3_e1.security.managers.CustomAuthManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthFilter extends OncePerRequestFilter{

  @Autowired
  CustomAuthManager customAuthManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,     
                                    HttpServletResponse response,   
                                    FilterChain filterChain)
                                    throws 
                                    ServletException, IOException {
        
     //Create a new Authentication
     //Delegate it to Authentication Manager
     //Get the object back.
     //if it is authenticated proceed futhur in the filter chain.

     
    String key = String.valueOf(request.getHeader("key"));

    CustomAuthentication customAuthentication = new CustomAuthentication();
    customAuthentication.setAuthenticaion(false);
    customAuthentication.setKey(key);
                                       
   var a =  this.customAuthManager.authenticate(customAuthentication);


       if(a.isAuthenticated()){
        SecurityContextHolder.getContext().setAuthentication(customAuthentication);//This is importent because for authorisation this object will be used.
        filterChain.doFilter(request, response);/*This is the proceeding step and
                                                 should execute for successfull authentication.*/
       }
    }



}
