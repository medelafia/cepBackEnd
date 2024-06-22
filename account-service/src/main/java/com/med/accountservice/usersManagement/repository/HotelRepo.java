package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel , Integer> {
    public List<Hotel> findAllByNameContains(String name) ;
}
