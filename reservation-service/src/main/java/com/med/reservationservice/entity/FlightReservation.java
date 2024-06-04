package com.med.reservationservice.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder @Getter @Setter
public class FlightReservation extends TravelReservation{

}
