package com.marriage.app.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marriage.app.entities.User;
import com.marriage.app.repo.marriage_repo;

@Service
public class HomeService {

    @Autowired
    private marriage_repo marriageRepo;

    public String register(User user) {

        if (user.getName() == null || user.getPassword() == null) {
            return "Name and password are required";
        }

        if (marriageRepo.findbyName(user.getName()) != null) {
            return "Name already exists";
        }

        marriageRepo.save(user);
        return "User registered successfully";
    }

    public ResponseEntity<User> login(User user) {

        User userFromDb = marriageRepo.findbyName(user.getName());

        if (userFromDb == null) {
            return ResponseEntity.notFound().build();
        }

        if (!userFromDb.getPassword().equals(user.getPassword())) {
            return ResponseEntity.notFound().build();
        }
        // we need to add the time when the user is active
        userFromDb.setActive_status( new Date());
        marriageRepo.save(userFromDb);

        return ResponseEntity.ok(userFromDb);
    }

    public ResponseEntity<ArrayList<User>> getAll(String gender) {
        if (gender.equals("man")) {
            ArrayList<User> users = marriageRepo.findByGender("female");
            for(User user: users){
                user.setPassword(null);
                user.setFav_user(null);
                // we need to minus the time when the user is active
                // user.setActive_status( new Date(System.currentTimeMillis() - user.getActive_status().getTime()));

            }


            return ResponseEntity.ok(users);
        } else {
            ArrayList<User> users = marriageRepo.findByGender("male");
            for(User user: users){
                user.setPassword(null);
                user.setFav_user(null);
                // we need to minus the time when the user is active
                // user.setActive_status( new Date(System.currentTimeMillis() - user.getActive_status().getTime()));

            }
            return ResponseEntity.ok(users);
        }

        // return ResponseEntity.ok(marriageRepo.findAll());
    }

}
