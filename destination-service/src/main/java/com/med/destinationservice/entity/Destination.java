package com.med.destinationservice.entity;

import com.med.destinationservice.enums.DestinationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String address ;
    private String country ;
    private String city ;
    @Enumerated(value = EnumType.STRING )
    private DestinationType destinationType ;

}
