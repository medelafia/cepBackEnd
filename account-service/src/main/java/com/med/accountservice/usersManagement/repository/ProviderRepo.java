package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepo extends JpaRepository<Provider , Integer> {
}
