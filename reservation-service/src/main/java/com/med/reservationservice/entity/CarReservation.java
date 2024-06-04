package com.med.reservationservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class CarReservation extends DaysReservation {
}
