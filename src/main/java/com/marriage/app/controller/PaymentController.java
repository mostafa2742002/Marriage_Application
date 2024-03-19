// package com.marriage.app.controller;
// import java.util.Collections;
// import java.util.List;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

// @RestController
// public class PaymentController {

//     @PostMapping("/create_order")
//     public String createOrder(@RequestBody OrderRequest orderRequest) {
//         return getOrderResponse(orderRequest);
//     }

//     @PostMapping("/complete_order")
//     public String completeOrder(@RequestBody CompleteOrderRequest completeOrderRequest) {
//         OrderRequest orderRequest = new OrderRequest();
//         orderRequest.setIntent(completeOrderRequest.getIntent());
        
//         return getOrderResponse(orderRequest);
//     }

//     @PostMapping("/get_client_token")
//     public String getClientToken(@RequestBody ClientTokenRequest clientTokenRequest) {
//         return getClientTokenResponse(clientTokenRequest);
//     }

//     @SuppressWarnings("null")
//     private String getOrderResponse(OrderRequest orderRequest) {
//         String accessToken = getAccessToken();
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.setBearerAuth(accessToken);
//         HttpEntity<OrderRequest> request = new HttpEntity<>(orderRequest, headers);
//         return new RestTemplate().postForObject(getEndpointUrl() + "/v2/checkout/orders", request, String.class);
//     }

//     @SuppressWarnings("null")
//     private String getClientTokenResponse(ClientTokenRequest clientTokenRequest) {
//         String accessToken = getAccessToken();
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.setBearerAuth(accessToken);
//         HttpEntity<String> request = new HttpEntity<>(headers);
//         return new RestTemplate().postForObject(getEndpointUrl() + "/v1/identity/generate-token", request, String.class);
//     }

//     @SuppressWarnings("null")
//     private String getAccessToken() {
//         String auth = client_id + ":" + client_secret;
//         MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//         map.add("grant_type", "client_credentials");
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//         headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//         headers.setBasicAuth(auth);
//         HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//         return new RestTemplate().postForObject(getEndpointUrl() + "/v1/oauth2/token", request, AccessTokenResponse.class).getAccess_token();
//     }

//     private String getEndpointUrl() {
//         return environment.equals("sandbox") ? "https://api-m.sandbox.paypal.com" : "https://api-m.paypal.com";
//     }

//     @PostMapping("/send_email_receipt")
//     public void sendEmailReceipt(@RequestBody EmailReceiptRequest emailReceiptRequest) {
//         String htmlEmailContent = "YOUR_HTML_CONTENT_HERE"; // Replace with your HTML content
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.setBearerAuth("REPLACE_WITH_SENDGRID_API_KEY"); // Replace with your SendGrid API key
//         EmailRequest emailRequest = new EmailRequest();
//         emailRequest.setPersonalizations(Collections.singletonList(new Personalization(Collections.singletonList(new To(emailReceiptRequest.getEmail())), "Thank you for purchasing our NFT!")));
//         emailRequest.setFrom(new From("mycompany@email.com"));
//         emailRequest.setContent(Collections.singletonList(new Content("text/html", htmlEmailContent)));
//         HttpEntity<EmailRequest> request = new HttpEntity<>(emailRequest, headers);
//         new RestTemplate().postForObject("https://api.sendgrid.com/v3/mail/send", request, String.class);
//     }

//     // Helper classes

//     static class AccessTokenResponse {
//         private String access_token;

//         public String getAccess_token() {
//             return access_token;
//         }
//     }

//     static class OrderRequest {
//         private String intent;

//         public String getIntent() {
//             return intent;
//         }

//         public void setIntent(String intent) {
//             this.intent = intent;
//         }
//     }

//     static class CompleteOrderRequest {
//         private String order_id;
//         private String intent;
//         private String email;

//         public String getOrder_id() {
//             return order_id;
//         }

//         public void setOrder_id(String order_id) {
//             this.order_id = order_id;
//         }

//         public String getIntent() {
//             return intent;
//         }

//         public void setIntent(String intent) {
//             this.intent = intent;
//         }

//         public String getEmail() {
//             return email;
//         }

//         public void setEmail(String email) {
//             this.email = email;
//         }
//     }

//     static class ClientTokenRequest {
//         private String access_token;
//         private String customer_id;

//         public String getAccess_token() {
//             return access_token;
//         }

//         public void setAccess_token(String access_token) {
//             this.access_token = access_token;
//         }

//         public String getCustomer_id() {
//             return customer_id;
//         }

//         public void setCustomer_id(String customer_id) {
//             this.customer_id = customer_id;
//         }
//     }

//     static class EmailReceiptRequest {
//         private String id;
//         private String email;

//         public String getId() {
//             return id;
//         }

//         public void setId(String id) {
//             this.id = id;
//         }

//         public String getEmail() {
//             return email;
//         }

//         public void setEmail(String email) {
//             this.email = email;
//         }
//     }

//     static class EmailRequest {
//         private List<Personalization> personalizations;
//         private From from;
//         private List<Content> content;

//         public List<Personalization> getPersonalizations() {
//             return personalizations;
//         }

//         public void setPersonalizations(List<Personalization> personalizations) {
//             this.personalizations = personalizations;
//         }

//         public From getFrom() {
//             return from;
//         }

//         public void setFrom(From from) {
//             this.from = from;
//         }

//         public List<Content> getContent() {
//             return content;
//         }

//         public void setContent(List<Content> content) {
//             this.content = content;
//         }
//     }

//     static class Personalization {
//         private List<To> to;
//         private String subject;

//         public Personalization(List<To> to, String subject) {
//             this.to = to;
//             this.subject = subject;
//         }

//         public List<To> getTo() {
//             return to;
//         }

//         public void setTo(List<To> to) {
//             this.to = to;
//         }

//         public String getSubject() {
//             return subject;
//         }

//         public void setSubject(String subject) {
//             this.subject = subject;
//         }
//     }

//     static class To {
//         private String email;

//         public To(String email) {
//             this.email = email;
//         }

//         public String getEmail() {
//             return email;
//         }

//         public void setEmail(String email) {
//             this.email = email;
//         }
//     }

//     static class From {
//         private String email;

//         public From(String email) {
//             this.email = email;
//         }

//         public String getEmail() {
//             return email;
//         }

//         public void setEmail(String email) {
//             this.email = email;
//         }
//     }

//     static class Content {
//         private String type;
//         private String value;

//         public Content(String type, String value) {
//             this.type = type;
//             this.value = value;
//         }

//         public String getType() {
//             return type;
//         }

//         public void setType(String type) {
//             this.type = type;
//         }

//         public String getValue() {
//             return value;
//         }

//         public void setValue(String value) {
//             this.value = value;
//         }
//     }

//     // Constants and configuration

//     @Value("${spring.paypal.client-id}")
//     private String client_id;

//     @Value("${spring.paypal.client-secret}")
//     private String client_secret;

//     @Value("${spring.paypal.environment}")
//     private String environment;

// }
