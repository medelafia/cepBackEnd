package com.med.accountservice.usersManagement.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class LoginResponse {
    String accessToken ;
    String refreshToken ;
}
