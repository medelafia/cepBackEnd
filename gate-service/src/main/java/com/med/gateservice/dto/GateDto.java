package com.med.gateservice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter @SuperBuilder
public class GateDto {
    protected String name ;
    protected String address ;
    protected String city ;
    protected String country ;
    protected float lat ;
    protected float lng ;
    protected String emailContact ;
    protected String nbPhoneContact;
}
