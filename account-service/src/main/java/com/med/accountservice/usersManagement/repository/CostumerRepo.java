package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepo extends JpaRepository<Costumer , Integer > {
}
