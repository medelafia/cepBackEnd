package com.med.gateservice.repositry;

import com.med.gateservice.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport , Integer > {
}
