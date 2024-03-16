// package com.marriage.app.stripe;

// import java.nio.file.Paths;

// import java.util.HashMap;
// import java.util.Map;

// import static spark.Spark.post;
// import static spark.Spark.port;
// import static spark.Spark.staticFiles;

// import com.google.gson.Gson;
// import com.google.gson.annotations.SerializedName;
// import com.google.gson.JsonSyntaxException;

// import com.stripe.Stripe;
// import com.stripe.net.ApiResource;
// import com.stripe.model.Event;
// import com.stripe.model.EventDataObjectDeserializer;
// import com.stripe.exception.SignatureVerificationException;
// import com.stripe.net.Webhook;
// import com.stripe.model.StripeObject;
// import com.stripe.model.checkout.Session;
// import com.stripe.param.checkout.SessionCreateParams;
// import com.stripe.model.Price;
// import com.stripe.param.PriceListParams;
// import com.stripe.model.PriceCollection;
// import com.stripe.model.Discount;
// import com.stripe.model.Subscription;


// public class StripeService {
//     Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
//     String endpointSecret = "whsec_12345";
// }
