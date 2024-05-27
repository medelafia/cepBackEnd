package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Costumer , Integer > {
}
