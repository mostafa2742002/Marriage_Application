package com.marriage.app.controller;
import java.util.Base64;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaymentController {

    @PostMapping("/api/paypal/create-subscription")
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

    @PostMapping("/api/paypal/cancel-subscription")
    public String cancelSubscription() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId + "/cancel";

        RestTemplate restTemplate = new RestTemplate();
        String requestJson = "{\"reason\":\"Not satisfied with the service\"}";

        return restTemplate.postForObject(url, createHttpEntity(requestJson, accessToken), String.class);
    }

    @PostMapping("/api/paypal/get-subscription")
    public String getSubscription() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, createHttpEntity(null, accessToken), String.class);
    }

    @PostMapping("/api/paypal/activate-subscription")
    public String activateSubscription() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId + "/activate";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, createHttpEntity(null, accessToken), String.class);
    }

    @PostMapping("/api/paypal/suspend-subscription")
    public String suspendSubscription() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId + "/suspend";

        RestTemplate restTemplate = new RestTemplate();
        String requestJson = "{\"reason\":\"Not satisfied with the service\"}";

        return restTemplate.postForObject(url, createHttpEntity(requestJson, accessToken), String.class);
    }

    @PostMapping("/api/paypal/update-subscription")
    public String updateSubscription() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId;

        RestTemplate restTemplate = new RestTemplate();
        String requestJson = "{\"plan_id\":\"P-6KL55661WD806080WMX5ZAKQ\"}";

        return restTemplate.exchange(url, org.springframework.http.HttpMethod.PATCH, createHttpEntity(requestJson, accessToken), String.class).getBody();
    }

    @PostMapping("/api/paypal/get-subscription-transactions")
    public String getSubscriptionTransactions() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId + "/transactions";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, createHttpEntity(null, accessToken), String.class);
    }

    @PostMapping("/api/paypal/get-subscription-invoices")
    public String getSubscriptionInvoices() {
        String accessToken = generateAccessToken();
        String subscriptionId = "I-0YJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" + subscriptionId + "/invoices";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, createHttpEntity(null, accessToken), String.class);
    }

    @PostMapping("/api/paypal/get-subscription-invoice")
    public String getSubscriptionInvoice() {
        String accessToken = generateAccessToken();
        String invoiceId = "INV2-7YUJXJXJXJXJX";
        String url = "https://api-m.sandbox.paypal.com/v1/invoicing/invoices/" + invoiceId;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, createHttpEntity(null, accessToken), String.class);
    }

    
}
