package com.med.usersservices.entity;

import com.med.usersservices.model.Flight;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Airline extends Provider{
    @Transient
    private List<Flight> flights ;
}
