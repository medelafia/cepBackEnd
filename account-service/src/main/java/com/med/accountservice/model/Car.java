package com.med.accountservice.model;


import com.med.accountservice.enums.FuelType;
import com.med.accountservice.enums.StyleType;
import com.med.accountservice.enums.TransType;
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
