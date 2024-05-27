package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel , Integer> {
}
