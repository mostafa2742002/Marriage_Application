package com.marriage.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marriage.app.entities.User;
import com.marriage.app.repo.marriage_repo;

@Service
public class UserService {

    @Autowired
    private marriage_repo marriageRepo;

    public ResponseEntity<User> getUser(String id) {

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(marriageRepo.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> addToFav(String id, String favId) {

        if (id == null || favId == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent() && marriageRepo.findById(favId).isPresent()) {
            User user = marriageRepo.findById(id).get();
            User favUser = marriageRepo.findById(favId).get();
            if (user.getFav_user() == null) {
                user.setFav_user(new ArrayList<User>());
            }
            // we need to check if the user is already in the fav list, if yes then remove
            // it from the list
            if (user.getFav_user().contains(favUser)) {
                user.getFav_user().remove(favUser);
                marriageRepo.save(user);
                return ResponseEntity.ok("User removed from fav");
            }
            user.getFav_user().add(favUser);
            marriageRepo.save(user);
            return ResponseEntity.ok("User added to fav");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ArrayList<User>> getFav(String id) {

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {
            User user = marriageRepo.findById(id).get();
            if (user.getFav_user() == null) {
                return ResponseEntity.ok(new ArrayList<User>());
            }
            return ResponseEntity.ok(user.getFav_user());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<Boolean> inMyFav(String id, String favId) {

        if (id == null || favId == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent() && marriageRepo.findById(favId).isPresent()) {
            User user = marriageRepo.findById(id).get();
            User favUser = marriageRepo.findById(favId).get();
            if (user.getFav_user() == null) {
                return ResponseEntity.ok(false);
            }
            if (user.getFav_user().contains(favUser)) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.ok(false);
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> setImage(String id, ArrayList<String> images) {

        if (id == null || images == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {
            User user = marriageRepo.findById(id).get();
            if (user.getImage_array() == null) {
                user.setImage_array(new ArrayList<String>());
            }
            user.getImage_array().addAll(images);
            marriageRepo.save(user);
            return ResponseEntity.ok("Images added successfully");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<ArrayList<String>> getImages(String id) {

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {
            User user = marriageRepo.findById(id).get();
            if (user.getImage_array() == null) {
                return ResponseEntity.ok(new ArrayList<String>());
            }
            return ResponseEntity.ok(user.getImage_array());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> addchatWith(String id, String chatId) {

        if (id == null || chatId == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent() && marriageRepo.findById(chatId).isPresent()) {
            User user = marriageRepo.findById(id).get();
            User chatUser = marriageRepo.findById(chatId).get();
            if (user.getChat_with() == null) {
                user.setChat_with(new ArrayList<String>());
            }
            if (chatUser.getChat_with() == null) {
                chatUser.setChat_with(new ArrayList<String>());
            }

            if (user.getChat_with().contains(chatId)) {
                return ResponseEntity.ok("Yes");
            }

            String subscription = user.getSubscription();

            if (subscription.equals("free")) {
                if (user.getChat_with().size() >= 2) {
                    return ResponseEntity.ok("No");
                } else {
                    user.getChat_with().add(chatId);
                }
            }

            if (subscription.equals("gold")) {
                user.getChat_with().add(chatId);
            }

            if (subscription.equals("silver")) {
                if (user.getChat_with().size() >= 10) {
                    return ResponseEntity.ok("No");
                } else {
                    user.getChat_with().add(chatId);
                }
            }

            if (subscription.equals("platinum")) {
                if (user.getChat_with().size() >= 5) {
                    return ResponseEntity.ok("No");
                } else {
                    user.getChat_with().add(chatId);
                }
            }

            marriageRepo.save(user);
            return ResponseEntity.ok("Yes");

        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> chatWith(String id) {

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {

            User user = marriageRepo.findById(id).get();

            String subscription = user.getSubscription();

            if (subscription.equals("free")) {
                if (user.getChat_with().size() >= 2) {
                    return ResponseEntity.ok("No");
                } else {
                    return ResponseEntity.ok("Yes");
                }
            }

            if (subscription.equals("gold")) {
                return ResponseEntity.ok("Yes");
            }

            if (subscription.equals("silver")) {
                if (user.getChat_with().size() >= 10) {
                    return ResponseEntity.ok("No");
                } else {
                    return ResponseEntity.ok("Yes");
                }
            }

            if (subscription.equals("platinum")) {
                if (user.getChat_with().size() >= 5) {
                    return ResponseEntity.ok("No");
                } else {
                    return ResponseEntity.ok("Yes");
                }
            }

            return ResponseEntity.ok("No");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
