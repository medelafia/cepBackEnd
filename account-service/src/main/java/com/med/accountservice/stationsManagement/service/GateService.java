package com.med.accountservice.stationsManagement.service;

import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.repository.GateRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    private GateRepo gateRepo;
    public GateService(GateRepo gateRepo) {
        this.gateRepo = gateRepo ;
    }
    public List<Gate> getAllGates() {
        return gateRepo.findAll() ;
    }

}
