package com.med.accountservice.reservationManagement.service;

import com.med.accountservice.reservationManagement.dto.PaymentInfoRequest;
import com.med.accountservice.reservationManagement.entity.PaymentInfo;
import com.med.accountservice.reservationManagement.repository.PaymentInfoRepo;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.param.AccountCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoService {
    @Autowired
    private PaymentInfoRepo paymentInfoRepo ;
    @Autowired
    private ReservationService reservationService;
    public PaymentInfo createAccount(PaymentInfoRequest paymentInfoRequest) {
        try {
            AccountCreateParams accountCreateParams = AccountCreateParams.builder()
                    .setEmail(paymentInfoRequest.getEmail())
                    .setCountry("US")
                    .build();
            Account account = Account.create(accountCreateParams) ;
            return paymentInfoRepo.save(PaymentInfo.builder()
                            .accountId(account.getId())
                            .accountNumber(paymentInfoRequest.getAccountNumber())
                            .accountHolderType(paymentInfoRequest.getAccountHolderType())
                            .accountHolderName(paymentInfoRequest.getAccountHolderType())
                            .email(paymentInfoRequest.getEmail())
                            .providerId(paymentInfoRequest.getUserId()).build());
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
