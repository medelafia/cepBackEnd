package com.med.accountservice.dto;

import com.med.accountservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder
public class AccountDto {
    private String username ;
    private String password ;
    private String email ;
    private String tel ;
    private String accountType ;
}
