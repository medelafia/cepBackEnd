package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room , Integer> {
}
