package com.med.offersservices.entity;

import com.med.offersservices.superClasses.Offer;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @Getter @Setter @SuperBuilder @NoArgsConstructor
public class Room extends Offer {
    private int hotelId ;
}
