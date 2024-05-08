package com.med.accountservice.entity;

import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.model.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private int imageId ;
    @Transient
    private Image logo ;
    private int accountId ;
}
