package com.marriage.app.service;

import java.io.IOException;
import java.util.Base64;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PayPalService {

    @Autowired
    private UserService userService;

    public String createSubscription() {
        String accessToken = generateAccessToken();
        String planId = "P-6KL55661WD806080WMX5ZAKQ";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions";

        RestTemplate restTemplate = new RestTemplate();
        String requestJson = "{\"plan_id\":\"" + planId
                + "\",\"application_context\":{\"user_action\":\"SUBSCRIBE_NOW\"}}";

        String r = restTemplate.postForObject(url, createHttpEntity(requestJson, accessToken), String.class);
        JSONObject jsonObject = new JSONObject(r);
        String id = jsonObject.getString("id");
        System.out.println("ID: " + id);
        return r;
    }

    private String generateAccessToken() {
        String clientId = "AYIwk-O9gB9ByHhHoXPlE1mNn0SGc3nmiYsihPFALjhYvt4A7bZtellrjGEHO3FWYqoubRkSav3KvS18";
        String clientSecret = "EGzpHHVo_wg3gUMwTSQYRODhBfIGfpP11-KKLsRrnP340atjjaM4VDfDtVcoUDyvgAi2mYhz3bXfpNx4";
        String base64Credentials = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

        String url = "https://api-m.sandbox.paypal.com/v1/oauth2/token";
        String requestBody = "grant_type=client_credentials";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = new RestTemplate().postForEntity(url, request, String.class);
        String responseBody = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(responseBody);
            return node.get("access_token").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpEntity<String> createHttpEntity(String requestBody, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Accept", "application/json");
        headers.add("Prefer", "return=representation");

        return new HttpEntity<>(requestBody, headers);
    }

    public String approveOrder(JsonNode req) {
        String PlanID = req.get("planID").asText();
        String UserID = req.get("user_id").asText();
        String OrderID = req.get("orderID").asText();

        if (PlanID.equals("P-7F506781903971727MYE52DY")) {
            userService.upgradeSubscribtion(UserID, "platinum", OrderID);
        } else if (PlanID.equals("P-05T194624Y154152FMYE5ZYA")) {
            userService.upgradeSubscribtion(UserID, "gold", OrderID);
        } else if (PlanID.equals("P-3VK67379VD872780JMYE5ZLI")) {
            userService.upgradeSubscribtion(UserID, "silver", OrderID);
        } else {
            return "Invalid Plan ID";
        }

        return "Approved";
    }

}
