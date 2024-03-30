package com.med.usersservices.repository;

import com.med.usersservices.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel , Integer> {
}
