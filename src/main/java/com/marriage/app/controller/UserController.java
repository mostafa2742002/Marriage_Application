package com.marriage.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marriage.app.dto.SetImages;
import com.marriage.app.entities.User;
import com.marriage.app.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getuser")
    public ResponseEntity<User> getUser(@RequestParam String id) {
        return userService.getUser(id);
    }

    @PostMapping("/addtofav")
    public ResponseEntity<String> addToFav(@RequestParam String id, @RequestParam String favId) {
        return userService.addToFav(id, favId);
    }

    @PostMapping("/getfav")
    public ResponseEntity<ArrayList<User>> getFav(@RequestParam String id) {
        return userService.getFav(id);
    }

    @PostMapping("/inmyfav")
    public ResponseEntity<Boolean> inMyFav(@RequestParam String id, @RequestParam String favId)
    {
        return userService.inMyFav(id, favId);
    }

    @PostMapping("/setimages")
    public ResponseEntity<String> setImage(@RequestBody SetImages image)
    {
        return userService.setImage(image.getId(), image.getImages());
    }
}
