package com.med.accountservice.entity;

import com.med.accountservice.enums.AccountType;
import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.model.Image;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username ;
    private String password ;
    private String email ;
    private String tel ;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType ;
}
