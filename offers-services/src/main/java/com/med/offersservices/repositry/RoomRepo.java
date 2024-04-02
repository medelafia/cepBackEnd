package com.med.offersservices.repositry;

import com.med.offersservices.entity.Room;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room , Integer> {
    public List<Room> findAllByHotelId(int id ) ;
}
