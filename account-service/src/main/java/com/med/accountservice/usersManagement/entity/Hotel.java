package com.med.accountservice.usersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.offersManagement.entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Hotel extends Provider{
    private int stars ;
    private float longitude ;
    private float latitude ;
    @ManyToMany
    private List<Amenitie> amenities ;
    public Hotel(Provider provider) {
        super(provider);
    }
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Room>  rooms ;
    public List<Room> createNewRoom(Room room){
        this.rooms.add(room) ;
        return rooms ;
    }
    public List<Room> deleteRoomById(int id) {
        rooms.stream().filter(room -> {
            return room.getId() != id ;
        }).collect(Collectors.toList()) ;
        return rooms ;
    }
}
