package com.med.accountservice.offersManagement.entity;


import com.med.accountservice.usersManagement.dto.ProviderResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private float price ;
    @Transient
    private ProviderResponse provider;
}
