package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel , Integer> {
    public List<Hotel> findAllByNameContains(String name) ;
    public Optional<Hotel> findByUsername(String username) ;
    @Query("SELECT MIN(r.price) FROM Hotel h , Room r WHERE h.id = r.hotel.id")
    public float getMinPrice(int id);
}
