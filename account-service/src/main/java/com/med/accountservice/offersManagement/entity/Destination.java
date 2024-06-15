package com.med.accountservice.offersManagement.entity;

import com.med.accountservice.enums.DestinationType;
import com.med.accountservice.imagesManagement.entity.Image;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String country ;
    private String city ;
    @Enumerated(value = EnumType.STRING )
    private DestinationType destinationType ;
    private String description ;
    @OneToMany
    private List<Image> images ;
    public List<Image> addImage(Image image) {
        this.getImages().add(image );
        return this.getImages() ;
    }
}
