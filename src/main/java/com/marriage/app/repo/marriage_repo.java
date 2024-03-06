package com.marriage.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marriage.app.entities.User;

@Repository
public interface marriage_repo  extends MongoRepository <User, String>{
    public User findByEmail(String email);
}
