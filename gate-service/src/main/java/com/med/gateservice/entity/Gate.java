package com.med.gateservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Gate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String address ;
    private String city ;
    private String country ;
    private float lat ;
    private float lng ;
    private String emailContact ;
    private String nbPhoneContact;
}
