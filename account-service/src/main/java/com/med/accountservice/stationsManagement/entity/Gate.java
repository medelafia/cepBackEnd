package com.med.accountservice.stationsManagement.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
