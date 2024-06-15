package com.med.accountservice.offersManagement.entity;


import com.med.accountservice.enums.FuelType;
import com.med.accountservice.enums.StyleType;
import com.med.accountservice.enums.TransType;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.stationsManagement.entity.Airport;
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
    private int year ;
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType ;
    @Enumerated(value = EnumType.STRING)
    private TransType transType ;
    @Enumerated(value = EnumType.STRING)
    private StyleType styleType ;
    @OneToMany
    private List<Image> images ;
    private int numberOfSeats ;
    private int numberOfDoors ;
    private int numberOfSuitcases ;
    private boolean airConditioning ;
    private boolean freeCancelation ;
    private boolean available  ;
    @ManyToOne
    private CarsAgency carsAgency ;
    @ManyToOne
    private Airport availableIn ;
    public List<Image> addImage(Image image) {
        this.getImages().add(image) ;
        return images ;
    }
}
