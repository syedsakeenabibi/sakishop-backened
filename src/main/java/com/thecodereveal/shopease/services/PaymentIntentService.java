package com.thecodereveal.shopease.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.thecodereveal.shopease.auth.entities.User;
import com.thecodereveal.shopease.entities.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentIntentService {


    // Inject the Stripe API key from application.properties
    public PaymentIntentService(@Value("${stripe.api.key}") String stripeApiKey) {
        // Initialize Stripe API key
        Stripe.apiKey = stripeApiKey;
    }

    public Map<String, String> createPaymentIntent(Order order) throws StripeException {
        // Get user and metadata
        User user = order.getUser();
        Map<String, String> metaData = new HashMap<>();
        metaData.put("orderId", order.getId().toString());

        // Create PaymentIntent parameters
        PaymentIntentCreateParams paymentIntentCreateParams = PaymentIntentCreateParams.builder()
                .setAmount((long) (order.getTotalAmount() * 100)) // Convert total amount to smallest currency unit (e.g., paise for INR)
                .setCurrency("inr") // Set currency to INR
                .putAllMetadata(metaData)
                .setDescription("Test Payment Project -1")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                )
                .build();

        // Create the PaymentIntent
        PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentCreateParams);

        // Return the client secret
        Map<String, String> response = new HashMap<>();
        response.put("client_secret", paymentIntent.getClientSecret());
        return response;
    }
}
