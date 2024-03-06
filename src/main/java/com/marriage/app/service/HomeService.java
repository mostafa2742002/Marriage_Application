package com.marriage.app.service;

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
        
        if (user.getEmail() == null || user.getPassword() == null) {
            return "Email and password are required";
        }

        if (marriageRepo.findByEmail(user.getEmail()) != null) {
            return "Email already exists";
        }

        marriageRepo.save(user);
        return "User registered successfully";
    }


    public ResponseEntity<User> login(User user) {
        
        User userFromDb = marriageRepo.findByEmail(user.getEmail());
        
        if (userFromDb == null) {
            return ResponseEntity.notFound().build();
        }

        if (userFromDb.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(userFromDb);
        }

        return ResponseEntity.notFound().build();
    }

}
