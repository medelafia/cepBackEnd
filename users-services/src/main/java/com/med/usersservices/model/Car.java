package com.med.usersservices.model;

import com.med.offersservices.enums.FuelType;
import com.med.offersservices.enums.StyleType;
import com.med.offersservices.enums.TransType;
import com.med.offersservices.model.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Car extends Offer {
    private String make ;
    private String model ;
    private int year ;
    private String color ;
    private FuelType fuelType ;
    private TransType transType ;
    private StyleType styleType ;
    private int imageId ;
    private Image image ;
}
