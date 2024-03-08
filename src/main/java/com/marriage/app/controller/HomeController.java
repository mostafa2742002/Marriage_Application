package com.marriage.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marriage.app.entities.User;
import com.marriage.app.service.HomeService;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // System.out.println(user);
        return homeService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return homeService.login(user);
    }

    @PostMapping("/getall")
    public ResponseEntity<ArrayList<User>> getAll(@RequestParam String gender) {
        return homeService.getAll(gender);
    }

}
