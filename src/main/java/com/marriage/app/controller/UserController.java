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

import jakarta.validation.constraints.NotNull;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getuser")
    public ResponseEntity<User> getUser(@RequestParam @NotNull String id) {
        return userService.getUser(id);
    }

    @PostMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/addtofav")
    public ResponseEntity<String> addToFav(@RequestParam @NotNull String id, @RequestParam @NotNull String favId) {
        return userService.addToFav(id, favId);
    }

    @PostMapping("/getfav")
    public ResponseEntity<ArrayList<User>> getFav(@RequestParam @NotNull String id) {
        return userService.getFav(id);
    }

    @PostMapping("/inmyfav")
    public ResponseEntity<Boolean> inMyFav(@RequestParam @NotNull String id, @RequestParam @NotNull String favId) {
        return userService.inMyFav(id, favId);
    }

    @PostMapping("/setimages")
    public ResponseEntity<String> setImage(@RequestBody JsonNode image) {
        String new_image = image.get("image").asText();
        String id = image.get("id").asText();
        return userService.setImage(id, new_image);
    }

    @PostMapping("/getimages")
    public ResponseEntity<ArrayList<String>> getImages(@RequestParam @NotNull String id) {
        return userService.getImages(id);
    }

    @PostMapping("addchatwith")
    public ResponseEntity<String> addchatWith(@RequestParam @NotNull String id, @RequestParam @NotNull String chatId) {
        return userService.addchatWith(id, chatId);
    }

    @PostMapping("chatwith")
    public ResponseEntity<String> chatWith(@RequestParam @NotNull String id) {
        return userService.chatWith(id);
    }

    @PostMapping("/upgrade/subscription")
    public ResponseEntity<String> upgradeSubscribtion(@RequestParam @NotNull String id, @RequestParam @NotNull String subscription) {
        return userService.upgradeSubscribtion(id, subscription);
    }

    @PostMapping("/getsubscription")
    public ResponseEntity<String> getSubscription(@RequestParam @NotNull String id) {
        return userService.getSubscription(id);
    }

    @PostMapping("/editpio")
    public ResponseEntity<String> editPio(@RequestParam @NotNull String id, @RequestParam @NotNull String pio) {
        return userService.editPio(id, pio);
    }

    @PostMapping("/search")
    public ResponseEntity<ArrayList<User>> search(@RequestParam @NotNull String search) {
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
    public ResponseEntity<String> forgotPassword(@RequestParam @NotNull String id, @RequestParam @NotNull String new_password) {
        return userService.forgotPassword(id, new_password);
    }

    @PostMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestParam @NotNull String id, @RequestParam @NotNull String old_password,
            @RequestParam @NotNull String new_password) {
        return userService.changePassword(id, old_password, new_password);
    }

    @PostMapping("/changephone")
    public ResponseEntity<String> changePhone(@RequestParam @NotNull String id, @RequestParam @NotNull String new_phone) {
        if (new_phone.contains("+") == false)
            new_phone = "+" + new_phone;
        return userService.changePhone(id, new_phone);
    }

    @PostMapping("/deleteaccount")
    public ResponseEntity<String> deleteAccount(@RequestParam @NotNull String id) {
        return userService.deleteAccount(id);
    }
}
