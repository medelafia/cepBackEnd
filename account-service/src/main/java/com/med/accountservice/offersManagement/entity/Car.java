package com.med.accountservice.offersManagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.enums.FuelType;
import com.med.accountservice.enums.StyleType;
import com.med.accountservice.enums.TransType;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.CarsAgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Car extends Offer {
    private String make ;
    private String model ;
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType ;
    @Enumerated(value = EnumType.STRING)
    private TransType transType ;
    @Enumerated(value = EnumType.STRING)
    private StyleType styleType ;
    @OneToOne
    private Image image ;
    private int seats ;
    private int doors ;
    private int bags ;
    private boolean airConditioning ;
    private boolean freeCancelation ;
    private boolean available  ;
    @ManyToOne
    @JsonIgnore
    private CarsAgency carsAgency ;
    @ManyToOne
    private Airport airport ;
}
