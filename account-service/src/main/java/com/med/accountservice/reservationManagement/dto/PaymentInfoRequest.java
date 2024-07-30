package com.med.accountservice.reservationManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class PaymentInfoRequest {
    private String accountHolderName ;
    private String accountHolderType ;
    private String routingNumber ;
    private  String accountNumber ;
    private String email ;
    private int userId ;
}
