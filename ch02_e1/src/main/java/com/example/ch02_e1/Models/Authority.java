package com.example.ch02_e1.Models;

import org.springframework.data.annotation.Id;

public class Authority {
    @Id
    private Integer id;
    private String name;

    public Integer getId() {
      return this.id;
    }
    public void setId(Integer value) {
      this.id = value;
    }

    public String getName() {
      return this.name;
    }
    public void setName(String value) {
      this.name = value;
    }
}
