package com.med.usersservices.repository;

import com.med.usersservices.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepo extends JpaRepository<Airline , Integer > {
}
