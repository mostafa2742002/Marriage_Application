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

    @PostMapping("/updateuser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
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
    public ResponseEntity<Boolean> inMyFav(@RequestParam String id, @RequestParam String favId) {
        return userService.inMyFav(id, favId);
    }

    @PostMapping("/setimages")
    public ResponseEntity<String> setImage(@RequestBody SetImages image) {
        return userService.setImage(image.getId(), image.getImages());
    }

    @PostMapping("/getimages")
    public ResponseEntity<ArrayList<String>> getImages(@RequestParam String id) {
        return userService.getImages(id);
    }

    @PostMapping("addchatwith")
    public ResponseEntity<String> addchatWith(@RequestParam String id, @RequestParam String chatId) {
        return userService.addchatWith(id, chatId);
    }

    @PostMapping("chatwith")
    public ResponseEntity<String> chatWith(@RequestParam String id) {
        return userService.chatWith(id);
    }

    @PostMapping("/upgrade/subscription")
    public ResponseEntity<String> upgradeSubscribtion(@RequestParam String id, @RequestParam String subscription) {
        return userService.upgradeSubscribtion(id, subscription);
    }

    @PostMapping("/getsubscription")
    public ResponseEntity<String> getSubscription(@RequestParam String id) {
        return userService.getSubscription(id);
    }

    @PostMapping("/editpio")    
    public ResponseEntity<String> editPio(@RequestParam String id, @RequestParam String pio) {
        return userService.editPio(id, pio);
    }
    
    @PostMapping("/search")
    public ResponseEntity<ArrayList<User>> search(@RequestParam String search) {
        return userService.search(search);
    }

    @PostMapping("/check/phone")
    public ResponseEntity<Boolean> checkPhone(@RequestParam String phone) {
        return userService.checkPhone(phone);
    }
}
