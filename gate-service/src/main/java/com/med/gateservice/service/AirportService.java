package com.med.gateservice.service;

import com.med.gateservice.dto.AirportDto;
import com.med.gateservice.entity.Airport;
import com.med.gateservice.mapper.AirportMapper;
import com.med.gateservice.repositry.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    AirportRepo airportRepo ;
    public AirportService(AirportRepo airportRepo) {
        this.airportRepo = airportRepo ;
    }
    public Airport getAirportById(int id){
        return airportRepo.findById(id).orElseThrow() ;
    }
    public List<Airport> getAllAirport() {
        return airportRepo.findAll() ;
    }
    public Airport addAirport(AirportDto airportDto) {
        return airportRepo.save(AirportMapper.toAirport(airportDto)) ;
    }
}
