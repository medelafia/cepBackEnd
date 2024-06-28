package com.med.reservationservice.service;

import com.med.reservationservice.dto.BankAccountRequest;
import com.med.reservationservice.entity.Reservation;
import com.med.reservationservice.repository.BankAccountRepo;
import com.med.reservationservice.repository.ReservationRepo;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.ExternalAccount;
import com.stripe.model.Transfer;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.ExternalAccountCollectionCreateParams;
import com.stripe.param.TransferCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepo accountRepo ;
    @Autowired
    private ReservationService reservationService;
    public Account createAccount(BankAccountRequest bankAccountRequest) {
        try {
            AccountCreateParams accountCreateParams = AccountCreateParams.builder()
                    .setEmail(bankAccountRequest.getEmail())
                    .setCountry("US")
                    .build();
            Account account =  Account.create(accountCreateParams);
            ExternalAccountCollectionCreateParams externalAccountCollectionCreateParams =
                    ExternalAccountCollectionCreateParams.builder()
                            .build() ;
            account.getExternalAccounts().create(ExternalAccountCollectionCreateParams.builder().build()) ;
            return null  ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
    public Transfer transfer( int reservationId ) {
        try {
                Reservation reservation = reservationService.findReservationById(reservationId) ;
                TransferCreateParams transferCreateParams = TransferCreateParams.builder()
                        .setCurrency("usd")
                        .setAmount(reservation.getTotalAmount())
                        .setDescription(accountRepo.findByUserId(reservation.getOffer().getProviderId()).get().getAccountId())
                        .build();
                return Transfer.create(transferCreateParams) ;

        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
