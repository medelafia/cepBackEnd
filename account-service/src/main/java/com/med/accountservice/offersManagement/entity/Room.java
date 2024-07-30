package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.enums.RoomType;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @AllArgsConstructor @Getter @Setter @SuperBuilder @NoArgsConstructor
public class Room extends Offer {
    @Enumerated(value = EnumType.STRING)
    private RoomType roomType ;
    private int adults ;
    private int childs ;
    private boolean available ;
    private int kingBeds ;
    private int twinsBeds ;
    private int roomNumber ;
    private boolean hasTv ;
    private boolean freeWifi  ;
    private boolean airConditioning;
    @OneToOne
    private Image image ;
    @ManyToOne
    @JsonIgnore
    private Hotel hotel ;
}
