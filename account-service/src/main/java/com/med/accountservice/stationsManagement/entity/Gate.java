package com.med.accountservice.stationsManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Gate {
    @Id
    private String id ;
    private String name ;
    private String address ;
    private String city ;
    private String country ;
    private float lat ;
    private float lng ;
    private String emailContact ;
    private String nbPhoneContact;
}
