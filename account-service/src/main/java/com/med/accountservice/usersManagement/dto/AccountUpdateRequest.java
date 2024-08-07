package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class AccountUpdateRequest {
    private String username ;
    private String email ;
    private String tel ;
}
