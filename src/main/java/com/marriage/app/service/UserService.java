package com.marriage.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            throw new NullPointerException("Id is required");
        }

        if (marriageRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(marriageRepo.findById(id).get());
        } else {
            throw new NullPointerException("User not found");
        }

    }

    public ResponseEntity<User> updateUser(User user) {

        if (user == null) {
            throw new NullPointerException("User is required");
        }
        User userFromDb = marriageRepo.findById(user.getId()).get();
        if (userFromDb == null) {
            throw new NullPointerException("User not found");
        }

        userFromDb = build_user(userFromDb, user);
        if (userFromDb == null) {
            throw new NullPointerException("User is required");
        }
        marriageRepo.save(userFromDb);
        return ResponseEntity.ok(userFromDb);
    }

    public User build_user(User userFromDb, User user) {
        // email, password, phone ,name, birthdate, gender ,nationality, live_situation,
        // living_place, language_for_communication, income, religious_denomination,
        // tribal_affiliation
        // health_status_woman_man, educational_level_woman_man,
        // marital_status_woman_man,work_status_woman_man,expected_marriage_date_woman,fav_communication_woman_man,wearing_hijab_woman_man
        // need_kids_woman_man, smoking_drinking_woman_man, skin_woman_man,
        // religious_commitment_woman_man,daily_habits_woman
        // weight_woman,height_woman,fav_user,image,image_array,active_status,subscription,chat_with,pio,latitude,longitude

        if (user.getEmail() != null) {
            userFromDb.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            userFromDb.setPassword(user.getPassword());
        }
        if (user.getPhone() != null) {
            userFromDb.setPhone(user.getPhone());
        }
        if (user.getName() != null) {
            userFromDb.setName(user.getName());
        }
        if(user.getUsername() != null){
            userFromDb.setUsername(user.getUsername());
        }
        if (user.getBirthdate() != null) {
            userFromDb.setBirthdate(user.getBirthdate());
        }
        if (user.getGender() != null) {
            userFromDb.setGender(user.getGender());
        }
        if (user.getNationality() != null) {
            userFromDb.setNationality(user.getNationality());
        }
        if (user.getLive_situation() != null) {
            userFromDb.setLive_situation(user.getLive_situation());
        }
        if (user.getLiving_place() != null) {
            userFromDb.setLiving_place(user.getLiving_place());
        }
        if (user.getLanguage_for_communication() != null) {
            userFromDb.setLanguage_for_communication(user.getLanguage_for_communication());
        }
        if (user.getIncome() != null) {
            userFromDb.setIncome(user.getIncome());
        }
        if (user.getReligious_denomination() != null) {
            userFromDb.setReligious_denomination(user.getReligious_denomination());
        }
        if (user.getTribal_affiliation() != null) {
            userFromDb.setTribal_affiliation(user.getTribal_affiliation());
        }
        if (user.getHealth_status_woman_man() != null) {
            userFromDb.setHealth_status_woman_man(user.getHealth_status_woman_man());
        }
        if (user.getEducational_level_woman_man() != null) {
            userFromDb.setEducational_level_woman_man(user.getEducational_level_woman_man());
        }
        if (user.getMarital_status_woman_man() != null) {
            userFromDb.setMarital_status_woman_man(user.getMarital_status_woman_man());
        }
        if (user.getWork_status_woman_man() != null) {
            userFromDb.setWork_status_woman_man(user.getWork_status_woman_man());
        }
        if (user.getExpected_marriage_date_woman() != null) {
            userFromDb.setExpected_marriage_date_woman(user.getExpected_marriage_date_woman());
        }
        if (user.getFav_communication_woman_man() != null) {
            userFromDb.setFav_communication_woman_man(user.getFav_communication_woman_man());
        }
        if (user.getWearing_hijab_woman_man() != null) {
            userFromDb.setWearing_hijab_woman_man(user.getWearing_hijab_woman_man());
        }
        if (user.getNeed_kids_woman_man() != null) {
            userFromDb.setNeed_kids_woman_man(user.getNeed_kids_woman_man());
        }
        if (user.getSmoking_drinking_woman_man() != null) {
            userFromDb.setSmoking_drinking_woman_man(user.getSmoking_drinking_woman_man());
        }
        if (user.getSkin_woman_man() != null) {
            userFromDb.setSkin_woman_man(user.getSkin_woman_man());
        }
        if (user.getReligious_commitment_woman_man() != null) {
            userFromDb.setReligious_commitment_woman_man(user.getReligious_commitment_woman_man());
        }
        if (user.getDaily_habits_woman() != null) {
            userFromDb.setDaily_habits_woman(user.getDaily_habits_woman());
        }
        if (user.getWeight_woman() != null) {
            userFromDb.setWeight_woman(user.getWeight_woman());
        }
        if (user.getHeight_woman() != null) {
            userFromDb.setHeight_woman(user.getHeight_woman());
        }
        if (user.getFav_user() != null) {
            userFromDb.setFav_user(user.getFav_user());
        }
        if (user.getImage() != null) {
            userFromDb.setImage(user.getImage());
        }
        if (user.getImage_array() != null) {
            userFromDb.setImage_array(user.getImage_array());
        }
        if (user.getActive_status() != null) {
            userFromDb.setActive_status(user.getActive_status());
        }
        if (user.getSubscription() != null) {
            userFromDb.setSubscription(user.getSubscription());
        }
        if (user.getChat_with() != null) {
            userFromDb.setChat_with(user.getChat_with());
        }
        if (user.getPio() != null) {
            userFromDb.setPio(user.getPio());
        }
        if (user.getLatitude() != null) {
            userFromDb.setLatitude(user.getLatitude());
        }
        if (user.getLongitude() != null) {
            userFromDb.setLongitude(user.getLongitude());
        }

        return userFromDb;
    }

    public ResponseEntity<String> addToFav(String id, String favId) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (favId == null) {
            throw new NullPointerException("FavId is required");
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
            throw new NullPointerException("User not found");
        }
    }

    public ResponseEntity<ArrayList<User>> getFav(String id) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (marriageRepo.findById(id).isPresent()) {
            User user = marriageRepo.findById(id).get();
            if (user.getFav_user() == null) {
                return ResponseEntity.ok(new ArrayList<User>());
            }
            return ResponseEntity.ok(user.getFav_user());
        } else {
            throw new NullPointerException("User not found");
        }

    }

    public ResponseEntity<Boolean> inMyFav(String id, String favId) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (favId == null) {
            throw new NullPointerException("FavId is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        if (!marriageRepo.findById(favId).isPresent()) {
            throw new NullPointerException("FavUser not found");
        }

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

    }

    public ResponseEntity<User> setImage(String id, String new_image) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (new_image == null) {
            throw new NullPointerException("Images is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        if (user.getImage_array() == null) {
            user.setImage_array(new ArrayList<String>());
        }
        user.getImage_array().add(new_image);
        marriageRepo.save(user);
        return ResponseEntity.ok(user);

    }

    public ResponseEntity<User> deleteImage(String id, String image) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (image == null) {
            throw new NullPointerException("Image is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        if (user.getImage_array() == null) {
            return ResponseEntity.ok(user);
        }
        if (user.getImage_array().contains(image)) {
            user.getImage_array().remove(image);
            marriageRepo.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.ok(user);
        }

    }

    public ResponseEntity<ArrayList<String>> getImages(String id) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        if (user.getImage_array() == null) {
            return ResponseEntity.ok(new ArrayList<String>());
        }
        return ResponseEntity.ok(user.getImage_array());

    }

    public ResponseEntity<String> addchatWith(String id, String chatId) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (chatId == null) {
            throw new NullPointerException("ChatId is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        if (!marriageRepo.findById(chatId).isPresent()) {
            throw new NullPointerException("ChatUser not found");
        }

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

    }

    public ResponseEntity<String> chatWith(String id) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

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

    }

    public ResponseEntity<String> upgradeSubscribtion(String id, String subscription, String orderID) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (subscription == null) {
            throw new NullPointerException("Subscription is required");
        }

        if (orderID == null) {
            throw new NullPointerException("OrderID is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        user.setSubscription(subscription);
        user.setSubscription_ID(orderID);
        user.setSubscription_Start(new Date());
        marriageRepo.save(user);
        return ResponseEntity.ok("Subscription upgraded successfully");

    }

    public ResponseEntity<String> getSubscription(String id) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        return ResponseEntity.ok(user.getSubscription());

    }

    public ResponseEntity<String> editPio(String id, String pio) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (pio == null) {
            throw new NullPointerException("Pio is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        user.setPio(pio);
        marriageRepo.save(user);
        return ResponseEntity.ok("Pio updated successfully");

    }

    public ResponseEntity<ArrayList<User>> search(String search) {

        if (search == null) {
            throw new NullPointerException("Search is required");
        }

        List<User> users = marriageRepo.findAll();
        ArrayList<User> result = new ArrayList<User>();
        for (User user : users) {
            if (user.getName().contains(search) || user.getUsername().contains(search) || user.getPhone().contains(search)){
                result.add(user);
            }
        }
        return ResponseEntity.ok(result);

    }

    public ResponseEntity<Boolean> checkPhone(String number) {

        if (number == null) {
            throw new NullPointerException("Number is required");
        }
        // System.out.println(number);
        User user = marriageRepo.findByPhone(number);
        // System.out.println(user);

        if (marriageRepo.findByPhone(number) != null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }

    }

    public ResponseEntity<String> forgotPassword(String id, String new_password) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }
        if (new_password == null) {
            throw new NullPointerException("New password is required");
        }
        User user = marriageRepo.findById(id).get();

        if (user == null) {
            throw new NullPointerException("User not found");
        }

        user.setPassword(new_password);
        marriageRepo.save(user);
        return ResponseEntity.ok("Password updated successfully");

    }

    public ResponseEntity<String> changePassword(String id, String old_password, String new_password) {
        if (id == null) {
            throw new NullPointerException("Id is required");
        }
        if (old_password == null) {
            throw new NullPointerException("Old password is required");
        }

        if (new_password == null) {
            throw new NullPointerException("New password is required");
        }

        User user = marriageRepo.findById(id).get();

        if (user == null) {
            throw new NullPointerException("User not found");
        }

        if (user.getPassword().equals(old_password)) {
            user.setPassword(new_password);
            marriageRepo.save(user);
            return ResponseEntity.ok("Password updated successfully");
        } else {
            throw new IllegalArgumentException("Invalid password");
        }

    }

    public ResponseEntity<String> changePhone(String id, String new_phone) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }
        if (new_phone == null) {
            throw new NullPointerException("New phone is required");
        }

        User user = marriageRepo.findById(id).get();

        if (user == null) {
            throw new NullPointerException("User not found");
        }

        user.setPhone(new_phone);
        marriageRepo.save(user);
        return ResponseEntity.ok("Phone updated successfully");

    }

    @SuppressWarnings("null")
    public ResponseEntity<String> deleteAccount(String id) {

        if (id == null) {
            throw new NullPointerException("Id is required");
        }

        if (!marriageRepo.findById(id).isPresent()) {
            throw new NullPointerException("User not found");
        }

        User user = marriageRepo.findById(id).get();
        marriageRepo.delete(user);
        return ResponseEntity.ok("Account deleted successfully");

    }
}
