package com.med.offersservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Gate {
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
