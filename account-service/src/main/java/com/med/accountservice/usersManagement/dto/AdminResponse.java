package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class AdminResponse {
    private int id ;
    private String email ;
    private String country ;
}
