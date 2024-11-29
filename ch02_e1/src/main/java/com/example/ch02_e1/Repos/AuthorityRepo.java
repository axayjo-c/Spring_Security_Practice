package com.example.ch02_e1.Repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ch02_e1.Models.Authority;
@Repository
public interface AuthorityRepo extends CrudRepository<Authority,Integer>{

    @Query("select * from authorities where id = :id")
    public Authority findAuthorityById(Integer id);
}
