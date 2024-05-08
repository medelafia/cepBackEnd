package com.med.accountservice.service;

import com.med.usersservices.entity.Client;
import com.med.usersservices.feignRepo.RecommendationProfileRepo;
import com.med.usersservices.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    ClientRepo clientRepo ;
    RecommendationProfileRepo recommendationProfileRepo ;
    public ClientServices(ClientRepo clientRepo) {
        this.clientRepo = clientRepo ;
    }
    public Client registerNewClient(Client client) {
        return clientRepo.save(client);
    }
    public List<Client> getAllClients() {
        List<Client> clients = clientRepo.findAll() ;
        clients.forEach(client -> {
            client.setRecommendationProfile(recommendationProfileRepo.getRecommendationProfileById(client.getRecommendationProfileId()));
        });
        return clients;
    }
}
