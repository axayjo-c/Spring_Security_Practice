package com.example.ch02_e1.Repos;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ch02_e1.Models.UserAuthority;



@Repository
public interface UserAuthoritiesRepo extends CrudRepository<UserAuthority,Integer>{

    @Query("select * from user_authorities where user_id = :userId")
    public List<UserAuthority> findAuthorityByUsername(Integer userId);
    
} 
