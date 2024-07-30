package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepo extends JpaRepository<Provider , Integer> {
    public Optional<Provider> findByUsername(String username) ;
}
