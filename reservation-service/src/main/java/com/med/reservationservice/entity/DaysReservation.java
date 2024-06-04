package com.med.reservationservice.entity;

import com.med.reservationservice.enums.DaysReservationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class DaysReservation extends Reservation {
    private Date startDate ;
    private Date endDate ;
}
