package com.med.destinationservice.mapper;

import com.med.destinationservice.dto.DestinationDto;
import com.med.destinationservice.entity.Destination;

public class DestinationMapper {
    public static Destination toDestination(DestinationDto destinationDto) {
        Destination destination = Destination.builder()
                .name(destinationDto.getName())
                .city(destinationDto.getCity())
                .country(destinationDto.getCountry())
                .address(destinationDto.getAddress())
                .destinationType(destinationDto.getDestinationType())
                .build();
        return destination ;
    }
    public static DestinationDto toDestinationDto(Destination destination){
        DestinationDto destinationDto = DestinationDto.builder()
                .name(destination.getName())
                .destinationType(destination.getDestinationType())
                .address(destination.getAddress())
                .city(destination.getCity())
                .country(destination.getCountry())
                .build();
        return destinationDto ;
    }
}
