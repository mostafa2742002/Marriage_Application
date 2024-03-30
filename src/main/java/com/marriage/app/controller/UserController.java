package com.marriage.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
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

    @PostMapping("/checkphone")
    public ResponseEntity<Boolean> checkPhone(@RequestBody JsonNode number) {
        String phonenumber = number.get("phonenumber").asText();
        if (phonenumber.contains("+") == false)
            phonenumber = "+" + phonenumber;

        return userService.checkPhone(phonenumber);
    }

    @PostMapping("/forgotpassword")
    public ResponseEntity<String> forgotPassword(@RequestParam String id, @RequestParam String new_password) {
        return userService.forgotPassword(id, new_password);
    }

    @PostMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestParam String id, @RequestParam String old_password,
            @RequestParam String new_password) {
        return userService.changePassword(id, old_password, new_password);
    }

    @PostMapping("/changephone")
    public ResponseEntity<String> changePhone(@RequestParam String id, @RequestParam String new_phone) {
        if (new_phone.contains("+") == false)
            new_phone = "+" + new_phone;
        return userService.changePhone(id, new_phone);
    }

    @PostMapping("/deleteaccount")
    public ResponseEntity<String> deleteAccount(@RequestParam String id) {
        return userService.deleteAccount(id);
    }
}
