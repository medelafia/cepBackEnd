package com.med.reservationservice.service;

import com.med.reservationservice.entity.Reservation;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String createPaymentLink(Reservation reservation) throws StripeException {
        Stripe.apiKey = "sk_test_51PGMCsAa8VuWvh2Fdo8cuKqEjtPcE5eugNuuGXUlk8PZGOPPPvAQJlCZmQ0G71eE62zH5whkfkUM9g8QbO9KhlhX00vz83lb9I";
        SessionCreateParams sessionCreateParams = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8087/reservations/pay/"+reservation.getId())
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1l)
                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setUnitAmount(reservation.getTotalAmount())
                                .setCurrency("usd")
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName(reservation.getTitle())
                                        .build())
                                .build())
                        .build())
                .build();
        Session session = Session.create(sessionCreateParams) ;
        return session.getUrl();
    }
}
