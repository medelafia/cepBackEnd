package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Getter @Setter
public class OrganizedTravel extends Travel {
    private String origin ;
    private String destination ;
    @OneToOne
    private Image cover ;
    @JsonIgnore
    @ManyToOne
    private TravelAgency travelAgency ;
    private int places ;
    private int nbDays ;
    private boolean includeTrans ;
    private boolean includeHotel ;
    private boolean limitPlaces ;
}
