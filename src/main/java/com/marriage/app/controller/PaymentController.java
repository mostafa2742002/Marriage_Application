package com.marriage.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import com.marriage.app.service.PayPalService;

@RestController
public class PaymentController {

    @Autowired
    private PayPalService payPalService;

    @PostMapping("/api/paypal/create-subscription")
    public String createSubscription() {
        return payPalService.createSubscription();
    }

    @PostMapping("/api/paypal/approve-order")
    public String approveOrder(@RequestBody JsonNode req) {
        return payPalService.approveOrder(req);
    }

    // @PostMapping("/api/paypal/get-subscription")
    // public String getSubscription() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId;

    // RestTemplate restTemplate = new RestTemplate();
    // return restTemplate.postForObject(url, createHttpEntity(null, accessToken),
    // String.class);
    // }

    // @PostMapping("/api/paypal/cancel-subscription")
    // public String cancelSubscription() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId + "/cancel";

    // RestTemplate restTemplate = new RestTemplate();
    // String requestJson = "{\"reason\":\"Not satisfied with the service\"}";

    // return restTemplate.postForObject(url, createHttpEntity(requestJson,
    // accessToken), String.class);
    // }

    // @PostMapping("/api/paypal/activate-subscription")
    // public String activateSubscription() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId + "/activate";

    // RestTemplate restTemplate = new RestTemplate();
    // return restTemplate.postForObject(url, createHttpEntity(null, accessToken),
    // String.class);
    // }

    // @PostMapping("/api/paypal/suspend-subscription")
    // public String suspendSubscription() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId + "/suspend";

    // RestTemplate restTemplate = new RestTemplate();
    // String requestJson = "{\"reason\":\"Not satisfied with the service\"}";

    // return restTemplate.postForObject(url, createHttpEntity(requestJson,
    // accessToken), String.class);
    // }

    // @PostMapping("/api/paypal/update-subscription")
    // public String updateSubscription() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId;

    // RestTemplate restTemplate = new RestTemplate();
    // String requestJson = "{\"plan_id\":\"P-6KL55661WD806080WMX5ZAKQ\"}";

    // return restTemplate.exchange(url, org.springframework.http.HttpMethod.PATCH,
    // createHttpEntity(requestJson, accessToken), String.class).getBody();
    // }

    // @PostMapping("/api/paypal/get-subscription-transactions")
    // public String getSubscriptionTransactions() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId + "/transactions";

    // RestTemplate restTemplate = new RestTemplate();
    // return restTemplate.postForObject(url, createHttpEntity(null, accessToken),
    // String.class);
    // }

    // @PostMapping("/api/paypal/get-subscription-invoices")
    // public String getSubscriptionInvoices() {
    // String accessToken = generateAccessToken();
    // String subscriptionId = "I-0YJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions/" +
    // subscriptionId + "/invoices";

    // RestTemplate restTemplate = new RestTemplate();
    // return restTemplate.postForObject(url, createHttpEntity(null, accessToken),
    // String.class);
    // }

    // @PostMapping("/api/paypal/get-subscription-invoice")
    // public String getSubscriptionInvoice() {
    // String accessToken = generateAccessToken();
    // String invoiceId = "INV2-7YUJXJXJXJXJX";
    // String url = "https://api-m.sandbox.paypal.com/v1/invoicing/invoices/" +
    // invoiceId;

    // RestTemplate restTemplate = new RestTemplate();
    // return restTemplate.postForObject(url, createHttpEntity(null, accessToken),
    // String.class);
    // }

}
