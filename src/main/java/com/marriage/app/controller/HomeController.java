package com.marriage.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marriage.app.entities.User;
import com.marriage.app.service.HomeService;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/register")
    public String register(User user) {
        return homeService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(User user) {
        return homeService.login(user);
    }

    
}
