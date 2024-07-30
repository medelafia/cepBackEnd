package com.med.accountservice.usersManagement.service;

import com.med.accountservice.messagesManagement.entity.Message;
import com.med.accountservice.messagesManagement.service.MessageService;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.service.GateService;
import com.med.accountservice.usersManagement.dto.AccountResponse;
import com.med.accountservice.usersManagement.dto.AdminResponse;
import com.med.accountservice.usersManagement.dto.CostumerResponse;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.usersManagement.mapper.AccountMapper;
import com.med.accountservice.usersManagement.mapper.AdminMapper;
import com.med.accountservice.usersManagement.mapper.CostumerMapper;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    private AdminRepo adminRepo ;
    @Autowired
    private CostumerRepo costumerRepo;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private GateService gateService ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private MessageService messageService ;
    @Autowired
    private AirlineRepo airlineRepo ;
    @Autowired
    private CarsAgencyRepo carsAgencyRepo ;
    @Autowired
    private RailwayOperatorRepo railwayOperatorRepo ;
    @Autowired
    private HotelRepo hotelRepo ;
    @Autowired
    private TravelAgencyRepo travelAgencyRepo ;
    public Admin getAuthenticated() {
        return adminRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get() ;
    }

    public void deleteUser(int id) {
        accountRepo.deleteById(id) ;
    }
    public void deleteGate(int id) {
        this.gateService.deleteGate(id);
    }
    public Gate addAirport(Airport airport) {
        return this.gateService.addGate(airport) ;
    }
    public Gate addTrainStation(TrainStation trainStation) {
        return this.gateService.addGate(trainStation )  ;
    }

    public void createUser(Account account) {
        account.setEmailVerified(false);
        account.setRegisterByGoogle(false);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        switch (account.getRole()) {
            case "ADMIN":
                adminRepo.save(Admin.builder()
                        .email(account.getEmail())
                        .username(account.getUsername())
                        .password(account.getPassword())
                        .emailVerified(account.isEmailVerified())
                        .registerByGoogle(account.isRegisterByGoogle())
                        .level(2).build());
                break;
            case "PROVIDER_AIRLINE":
                airlineRepo.save(new Airline(AccountMapper.toProvider(account)));
                break;
            case "PROVIDER_CARAGENCY":
                carsAgencyRepo.save(new CarsAgency(AccountMapper.toProvider(account)));
                break;
            case "PROVIDER_TRAVELAGENCY":
                travelAgencyRepo.save(new TravelAgency(AccountMapper.toProvider(account)));
                break;
            case "PROVIDER_HOTEL":
                hotelRepo.save(new Hotel(AccountMapper.toProvider(account)));
                break;
            case "PROVIDER_RAILWAYOPERATOR":
                railwayOperatorRepo.save(new RailwayOperator(AccountMapper.toProvider(account)));
                break;
        }
    }

    public List<AccountResponse> getAllUsers() {
        return accountRepo.findAll()
                .stream()
                .map(account -> AccountResponse.builder()
                        .id(account.getId())
                        .email(account.getEmail())
                        .username(account.getUsername())
                        .role(account.getRole())
                        .build())
                .collect(Collectors.toList());
    }
    public List<Message> getUnreadMessages() {
        return messageService.getAllNotReadMessages() ;
    }
    public List<Message> getAllMessages() {
        return messageService.getAllMessages() ;
    }
    public List<Message> getNewMessages() {
        return messageService.getNewMessages() ;
    }
}
