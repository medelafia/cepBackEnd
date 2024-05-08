package com.med.accountservice.repository;


import com.med.accountservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
}
