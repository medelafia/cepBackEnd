package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class PasswordRequest {
    private String username ;
    private String currentPassword ;
    private String newPassword ;
}
