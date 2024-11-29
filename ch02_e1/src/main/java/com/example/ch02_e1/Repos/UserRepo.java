package com.example.ch02_e1.Repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ch02_e1.Models.User;
@Repository
public interface UserRepo extends CrudRepository<User,Integer>{
    @Query("SELECT * FROM users WHERE username = :username")
    public User findUserByUsername(String username);

}
