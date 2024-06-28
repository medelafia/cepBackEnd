package com.med.reservationservice.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class BankAccountRequest {
    private String accountHolderName ;
    private String accountHolderType ;
    private String routingNumber ;
    private  String accountNumber ;
    private String email ;
    private int userId ;
}
