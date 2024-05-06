package com.med.usersservices.entity;

import com.med.usersservices.enums.ProviderType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@SuperBuilder
public class Provider{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String CompanyName ;
    private String country ;
    @Enumerated(value = EnumType.STRING)
    private ProviderType providerType ;
}
