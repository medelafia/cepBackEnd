package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Hotel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private int nbStars ;
    private String address ;
    private String country ;
    private String city ;
    private float longitude ;
    private float latitude ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Room>  rooms ;
}
