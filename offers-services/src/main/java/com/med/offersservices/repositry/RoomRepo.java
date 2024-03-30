package com.med.offersservices.repositry;

import com.med.offersservices.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room , Integer> {
}
