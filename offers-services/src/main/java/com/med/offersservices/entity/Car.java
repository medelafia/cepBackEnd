package com.med.offersservices.entity;

import com.med.offersservices.enums.FuelType;
import com.med.offersservices.enums.StyleType;
import com.med.offersservices.enums.TransType;
import com.med.offersservices.model.Image;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Car extends Offer {
    private String make ;
    private String model ;
    private int year ;
    private String color ;
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType ;
    @Enumerated(value = EnumType.STRING)
    private TransType transType ;
    @Enumerated(value = EnumType.STRING)
    private StyleType styleType ;
    private int imageId;
    @Transient
    private Image image ;
}
