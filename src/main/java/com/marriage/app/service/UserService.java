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
            // we need to check if the user is already in the fav list, if yes then remove it from the list
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

    // public ResponseEntity<String> removeFromFav(String id, String favId) {

    //     if (id == null || favId == null) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     if (marriageRepo.findById(id).isPresent() && marriageRepo.findById(favId).isPresent()) {
    //         User user = marriageRepo.findById(id).get();
    //         User favUser = marriageRepo.findById(favId).get();
    //         user.getFav_user().remove(favUser);
    //         marriageRepo.save(user);
    //         return ResponseEntity.ok("User removed from fav");
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    public ResponseEntity<User> getFav(String id) {

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        if (marriageRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(marriageRepo.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
