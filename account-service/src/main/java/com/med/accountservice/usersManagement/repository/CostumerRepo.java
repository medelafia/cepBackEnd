package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepo extends JpaRepository<Costumer , Integer > {
    public Optional<Costumer> findByUsername(String username) ;
}

