package com.med.accountservice.offersManagement.entity;

import com.med.accountservice.enums.RoomType;
import com.med.accountservice.imagesManagement.entity.Image;
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
    private int nbOfRooms ;
    @Enumerated(value = EnumType.STRING)
    private RoomType roomType ;
    private int nbOfAdults ;
    private int nbOfChilds ;
    private boolean available ;
    private int roomNumber ;
    @OneToMany
    private List<Image> images ;
    @ManyToOne
    private Hotel hotel ;

    public List<Image> addImage(Image image) {
        this.getImages().add(image) ;
        return this.getImages() ;
    }
}
