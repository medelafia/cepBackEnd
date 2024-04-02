package com.med.offersservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
public class Destination {
    private int id ;
    private String name ;
    private String address ;
    private String country ;
    private String city ;
}
