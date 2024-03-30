package com.med.usersservices.entity;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class Client extends User{
    private String firstName ;
    private String lastName ;
    private String sexe ;
    private int age ;
}
