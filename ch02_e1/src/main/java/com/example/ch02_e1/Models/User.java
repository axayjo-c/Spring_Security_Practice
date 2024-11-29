package com.example.ch02_e1.Models;

import java.util.List;

import org.springframework.data.annotation.Id;


public class User {
    @Id
    Integer id;
    String username;
    String password;

    

    public Integer getId() {
      return this.id;
    }
    public void setId(Integer value) {
      this.id = value;
    }

    public String getUsername() {
      return this.username;
    }
    public void setUsername(String value) {
      this.username = value;
    }

    public String getPassword() {
      return this.password;
    }
    public void setPassword(String value) {
      this.password = value;
    }




}
