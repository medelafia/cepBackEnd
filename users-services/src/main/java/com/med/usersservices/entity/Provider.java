package com.med.usersservices.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@SuperBuilder
public class Provider extends User{
    private String CompanyName ;
    private String country ;
}
