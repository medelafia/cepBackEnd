package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.imagesManagement.entity.Image;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Provider extends Account {
    private String CompanyName ;
    private String country ;
    @Enumerated(value = EnumType.STRING)
    private ProviderType providerType ;
    @OneToOne
    private Image logo ;
    private int accountId ;
    private int nbReviews ;
    private float score ;
}
