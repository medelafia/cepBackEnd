package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class GRegistrationRequest {
    private String email ;
    private String firstName ;
    private String lastName ;
    private String username ;
    private String imageProfileUrl ;
    private String accountType ;
}
