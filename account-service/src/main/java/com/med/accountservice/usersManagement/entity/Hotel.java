package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.Room;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Hotel extends Provider {
    private int nbStars ;
    private String address ;
    private String country ;
    private String city ;
    private float longitude ;
    private float latitude ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Room>  rooms ;
}
