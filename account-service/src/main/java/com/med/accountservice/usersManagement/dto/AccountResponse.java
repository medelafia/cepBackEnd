package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class AccountResponse {
    private int id ;
    private String username ;
    private String email ;
    private String role ;
}
