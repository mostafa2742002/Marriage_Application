package com.marriage.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marriage.app.entities.User;
import com.marriage.app.repo.marriage_repo;

@Service
public class HomeService {

    @Autowired
    private marriage_repo marriageRepo;

    public User register(User user) {

        if (user.getUsername() == null) {
            throw new IllegalArgumentException("User Name is required");
        }

        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Password is required");
        }

        if (marriageRepo.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("User Name already exists");
        }

        if (marriageRepo.findByPhone(user.getPhone()) != null) {
            throw new IllegalArgumentException("Phone already exists");
        }
        System.out.println(user.getPassword());

        return marriageRepo.save(user);
    }

    public ResponseEntity<User> login(User user) {

        User userFromDb = marriageRepo.findByUsername(user.getUsername());

        if (userFromDb == null) {
            throw new NullPointerException("User not found");
        }

        if (!userFromDb.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        // we need to add the time when the user is active
        userFromDb.setActive_status(new Date());
        if (user.getImage() != null) {
            userFromDb.setImage(user.getImage());
        }

        marriageRepo.save(userFromDb);
        System.out.println(user.getPassword());
        return ResponseEntity.ok(userFromDb);
    }

    public ResponseEntity<ArrayList<User>> getAll(String gender) {
        if (gender.equals("Male")) {
            ArrayList<User> users = marriageRepo.findByGender("Female");
            for (User user : users) {
                user.setPassword(null);
                user.setFav_user(null);
                // we need to minus the time when the user is active
                // user.setActive_status( new Date(System.currentTimeMillis() -
                // user.getActive_status().getTime()));

            }

            return ResponseEntity.ok(users);
        } else if (gender.equals("Female")) {
            ArrayList<User> users = marriageRepo.findByGender("Male");
            for (User user : users) {
                user.setPassword(null);
                user.setFav_user(null);
                // we need to minus the time when the user is active
                // user.setActive_status( new Date(System.currentTimeMillis() -
                // user.getActive_status().getTime()));

            }
            return ResponseEntity.ok(users);
        }

        return ResponseEntity.notFound().build();

        // return ResponseEntity.ok(marriageRepo.findAll());
    }

}
