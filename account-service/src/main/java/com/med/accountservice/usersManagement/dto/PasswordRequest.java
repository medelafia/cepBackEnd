package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class PasswordRequest {
    private String currentPassword ;
    private String newPassword ;
}
