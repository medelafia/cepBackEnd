package com.med.gateservice.mapper;

import com.med.gateservice.dto.AirportDto;
import com.med.gateservice.entity.Airport;
import com.med.gateservice.enums.AirportType;

public class AirportMapper {
    public static Airport toAirport(AirportDto airportDto) {
        return Airport.builder()
                .name(airportDto.getName())
                .address(airportDto.getAddress() )
                .emailContact(airportDto.getEmailContact())
                .lng(airportDto.getLng())
                .lat(airportDto.getLat())
                .city(airportDto.getCity())
                .country(airportDto.getCountry())
                .nbPhoneContact(airportDto.getNbPhoneContact())
                .airportType(AirportType.NATIONAL)
                .build() ;
    }
    public static AirportDto toAirportDto(Airport airport) {
        return AirportDto.builder()
                .name(airport.getName())
                .address(airport.getAddress() )
                .emailContact(airport.getEmailContact())
                .lng(airport.getLng())
                .lat(airport.getLat())
                .city(airport.getCity())
                .country(airport.getCountry())
                .nbPhoneContact(airport.getNbPhoneContact())
                .airportType(AirportType.NATIONAL)
                .build() ;
    }
}
