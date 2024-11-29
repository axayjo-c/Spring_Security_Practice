package com.example.ch02_e1.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ch02_e1.Models.Authority;
import com.example.ch02_e1.Models.UserAuthority;
import com.example.ch02_e1.Repos.AuthorityRepo;
import com.example.ch02_e1.Repos.UserAuthoritiesRepo;

@Service
public class UserAuthorityManager {

    @Autowired
    UserAuthoritiesRepo userAuthoritiesRepo;
    @Autowired
    AuthorityRepo authorityRepo;

    List<Authority> getAuthorities(Integer userId){
        System.out.println("user id is " + userId);
        List<UserAuthority> userAuthorities = userAuthoritiesRepo.findAuthorityByUsername(userId);
        List<Authority> authorities = new ArrayList<>();
        userAuthorities.forEach((u)->authorities.add(authorityRepo.findAuthorityById(u.getAuthorityId())));
        return authorities;
    }

}
