package com.med.offersservices.superClasses;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.jmx.export.annotation.ManagedNotifications;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Setter @Getter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private double price ;
}
