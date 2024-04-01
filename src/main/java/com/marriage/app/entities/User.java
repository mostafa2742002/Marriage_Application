package com.marriage.app.entities;

import java.util.ArrayList;
import java.util.Date;

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

    private String username; // username of the user

    private String birthdate; // birthdate of the user

    private String gender; // male or female

    private String nationality; // nationality of the user

    private String live_situation; // live situation of the user (alone, with kids, with parents, etc.)

    private String living_place; // living place of the user (my home, my parents home, etc.)

    private String language_for_communication; // language for communication of the user (english, french, etc.)

    private String income; // income of the user

    private String religious_denomination;// religious denomination of the user (سني او شيعي او اسماعيلي او جعفري)

    private String tribal_affiliation; // tribal affiliation of the user (انتمي لعائلة قبلية او لا انتمي لعائلة قبلية
                                       // او افضل الا اجيب)

    private String health_status_woman_man; // health status of the user (في صحه جيده او اعاني من مرض مزمن )

    private String educational_level_woman_man; // educational level of the user (primary, secondary, university, etc.)

    private String marital_status_woman_man; // marital status of the user (مطلقة او ارملة او عزباء)

    private String work_status_woman_man; // work status of the user (student, employee, etc.)

    private String expected_marriage_date_woman; // expected marriage date of the user (في اسرع وقت او خلاص سنتين او لسه
                                                 // مش متاكده)

    private String fav_communication_woman_man; // favorite communication of the user (محادثه او محادثه وصوت او محادثه
                                                // وصوت وصوره)

    private String wearing_hijab_woman_man; // if the user wears hijab or not(محجبة او منتقبة او حره)

    private String need_kids_woman_man; // if the user needs kids or not (بأسرع وقت ممكن او مع مرور الوقت )

    private String smoking_drinking_woman_man; // if the user smokes or not (مدخنة او لا ادخن)

    private String skin_woman_man; // skin of the user (white, black, etc.)

    private String religious_commitment_woman_man; // religious commitment of the user (ملتزمة او مرنه او لا اهتم)

    private ArrayList<String> daily_habits_woman; // daily habits of the user (احب القراءة او السباحه )

    private String weight_woman; // weight of the user

    private String height_woman; // height of the user

    private ArrayList<User> fav_user; // favorite users of the user

    private String image;

    private ArrayList<String> image_array;

    private Date active_status;

    private String subscription;

    private ArrayList<String> chat_with;

    private String pio = "hey, i am using marriage app";

    private String latitude;

    private String longitude;

    private String city;

    private String country;
}
