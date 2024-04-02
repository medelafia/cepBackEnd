package com.med.usersservices.model;

import com.med.usersservices.enums.FuelType;
import com.med.usersservices.enums.StyleType;
import com.med.usersservices.enums.TransType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
}
