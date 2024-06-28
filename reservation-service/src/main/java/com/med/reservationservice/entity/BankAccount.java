package com.med.reservationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity @AllArgsConstructor@NoArgsConstructor @Builder @Getter
@Setter
public class BankAccount {
    @Id
    private String accountId ;
    private String accountHolderName ;
    private String accountHolderType ;
    private String routingNumber ;
    private  String accountNumber ;
    private String email ;
    private int userId ;
}
