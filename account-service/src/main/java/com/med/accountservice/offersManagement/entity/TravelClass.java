package com.med.accountservice.offersManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class TravelClass {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id  ;
    private String className ;
    private float classPrice ;
    private int price ;
    private int nbPlaces ;
    private int reservedPlace ;
}
