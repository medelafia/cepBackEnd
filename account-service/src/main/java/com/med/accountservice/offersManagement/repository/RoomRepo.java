package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room , Integer> {
    public List<Room> findAllByAvailableAAndHotelId(int id) ;
}
