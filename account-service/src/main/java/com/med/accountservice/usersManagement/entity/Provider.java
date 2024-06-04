package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.imagesManagement.entity.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@SuperBuilder
public class Provider extends Account {
    private String CompanyName ;
    private String country ;
    @Enumerated(value = EnumType.STRING)
    private ProviderType providerType ;
    @OneToOne
    private Image logo ;
    private int accountId ;
    @Transient
    private int nbReviews ;
    @Transient
    private float score ;
    @Transient
    @OneToOne
    private Hotel hotel ;
    @OneToOne
    @Transient
    private CarsAgency carsAgency ;
    @Transient
    @OneToOne
    private RailwayOperator railwayOperator ;
    @OneToOne
    @Transient
    private TravelAgency travelAgency ;
    @Transient
    @OneToOne
    private Airline airline;
}
