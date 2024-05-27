package com.med.accountservice.offersManagement.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @Getter @Setter @SuperBuilder @NoArgsConstructor
public class Room extends Offer {
    private int hotelId ;
}
