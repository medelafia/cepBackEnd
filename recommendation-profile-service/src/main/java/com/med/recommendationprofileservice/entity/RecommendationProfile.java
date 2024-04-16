package com.med.recommendationprofileservice.entity;

import com.med.recommendationprofileservice.enums.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Builder
public class RecommendationProfile {
    @Id
    private  int id ;
    private int clientId ;
    @Enumerated(value = EnumType.STRING)
    private DestinationType destinationType ;
    private String favoriteCountry ;
    private String favoriteCity ;
    @Enumerated(value = EnumType.STRING )
    private FlightClass favoriteFlightClass ;
    private String favoriteCar ;
    @Enumerated(value = EnumType.STRING )
    private CarStyleType favoriteCarStyle ;
    @Enumerated(value = EnumType.STRING )
    private TransType favoriteCarTransType ;
    @Enumerated(value = EnumType.STRING )
    private FuelType favoriteCarFuelType ;
}
