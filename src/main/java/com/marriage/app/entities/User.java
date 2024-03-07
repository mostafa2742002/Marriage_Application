package com.marriage.app.entities;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
    
    @Id
    private String id;

    private String email; // email of the user

    private String password; // password of the user

    private String phone; // phone number of the user

    private String name; // name of the user

    private String birthdate; // birthdate of the user

    private String gender; // man or woman

    private String study_level; // study level of the user (primary, secondary, university, etc.)

    private String work_situation; // work situation of the user (student, employee, etc.)

    private String nationality; // nationality of the user

    private String live_situation; // live situation of the user (alone, with kids, with parents, etc.)

    private String expected_marriage_date; // expected marriage date of the user (one year, two years, etc.)

    private String living_place; // living place of the user (my home, my parents home, etc.)

    private String smoking; // if the user smokes or not

    private String drinking;   // if the user drinks or not

    private String language_for_communication; // language for communication of the user (english, french, etc.)

    private String income; // income of the user

    private String need_kids; // if the user needs kids or not

    private ArrayList<User> fav_user; // favorite users of the user
}
