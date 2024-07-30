package com.med.accountservice.reservationManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentInfo {
    @Id
    private String accountId ;
    private String accountHolderName ;
    private String accountHolderType ;
    private String routingNumber ;
    private  String accountNumber ;
    @Column(unique = true)
    private String email ;
    private int providerId ;
}
