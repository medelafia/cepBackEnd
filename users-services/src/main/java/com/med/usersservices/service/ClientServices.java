package com.med.usersservices.service;

import com.med.usersservices.entity.Client;
import com.med.usersservices.repository.ClientRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    ClientRepo clientRepo ;
    public ClientServices(ClientRepo clientRepo) {
        this.clientRepo = clientRepo ;
    }
    public Client registerNewClient(Client client) {
        return clientRepo.save(client);
    }
    public List<Client> getAllClients() {
        return clientRepo.findAll() ;
    }
}
