package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.RailwayOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RailwayOperatorRepo extends JpaRepository<RailwayOperator , Integer> {
    public Optional<RailwayOperator> findByUsername(String username) ;
}
