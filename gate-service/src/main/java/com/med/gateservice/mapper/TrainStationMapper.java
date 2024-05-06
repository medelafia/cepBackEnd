package com.med.gateservice.mapper;

import com.med.gateservice.dto.TrainStationDto;
import com.med.gateservice.entity.TrainStation;

public class TrainStationMapper {
    public static TrainStation toTrainStation(TrainStationDto trainStationDto) {
        TrainStation trainStation = TrainStation.builder()
                .name(trainStationDto.getName())
                .city(trainStationDto.getCity())
                .lat(trainStationDto.getLat())
                .lng(trainStationDto.getLng())
                .address(trainStationDto.getAddress() )
                .emailContact(trainStationDto.getEmailContact())
                .nbPhoneContact(trainStationDto.getNbPhoneContact())
                .platformNb(trainStationDto.getPlatformNb())
                .build() ;
        return trainStation ;
    }
    public static TrainStationDto toTrainStationDto(TrainStation trainStation) {
        TrainStationDto trainStationDto = TrainStationDto.builder()
                .name(trainStation.getName())
                .country(trainStation.getCountry())
                .lat(trainStation.getLat() )
                .lng(trainStation.getLng() )
                .emailContact(trainStation.getEmailContact() )
                .address(trainStation.getAddress())
                .nbPhoneContact(trainStation.getNbPhoneContact() )
                .platformNb(trainStation.getPlatformNb())
                .build() ;
        return trainStationDto ;
    }
}
