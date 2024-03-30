package com.med.offersservices.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @Getter @Setter @SuperBuilder
public class Room extends Offer{

}
