package com.med.accountservice.stationsManagement.service;

import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.stationsManagement.repository.GateRepo;
import com.med.accountservice.stationsManagement.repository.TrainStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    @Autowired
    private GateRepo gateRepo;
    @Autowired
    private AirportRepo airportRepo ;
    @Autowired
    private TrainStationRepo trainStationRepo ;
    public List<Gate> getAllGates() {
        return gateRepo.findAll() ;
    }
    public Gate addGate(Airport airport) {
        return airportRepo.save(airport) ;
    }
    public Gate addGate(TrainStation trainStation ) {
        return trainStationRepo.save(trainStation) ;
    }
    public List<Airport> getAllAirports(){
        return airportRepo.findAll() ;
    }
    public List<TrainStation> getAllTrainStations() {
        return trainStationRepo.findAll() ;
    }
    public void deleteGate(int id) {
        gateRepo.deleteById(id) ;
    }
}
