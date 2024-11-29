package com.example.ch02_e1.Models;

public class UserAuthority {
    Integer userId;
    Integer authorityId;

    public Integer getUserId() {
      return this.userId;
    }
    public void setUserId(Integer value) {
      this.userId = value;
    }

    public Integer getAuthorityId() {
      return this.authorityId;
    }
    public void setAuthorityId(Integer value) {
      this.authorityId = value;
    }
}
