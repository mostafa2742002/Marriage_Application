package com.marriage.app.repo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marriage.app.entities.User;

@Repository
public interface marriage_repo  extends MongoRepository <User, String>{
    public User findByEmail(String email);

    // i want to get the user by gender 
    public ArrayList<User> findByGender(String gender);
}
