package com.med.accountservice.entity;

import com.med.accountservice.model.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@SuperBuilder
public class Hotel extends Provider {
    private int nbStars ;
    private String address ;
    private String country ;
    private String city ;
    private float longitude ;
    private float latitude ;
    @Transient
    private List<Room> rooms ;
}
