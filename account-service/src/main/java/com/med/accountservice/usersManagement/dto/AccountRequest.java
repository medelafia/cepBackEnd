package com.med.accountservice.usersManagement.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class AccountRequest {
    private String username ;
    private String password ;
    private String email ;
    private boolean registerByGoogle ;
    private boolean emailVerified ;
}
