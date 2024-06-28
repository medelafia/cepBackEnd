package com.med.reservationservice.repository;

import com.med.reservationservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepo extends JpaRepository<BankAccount, String > {
    public Optional<BankAccount> findByUserId(int id) ;
}
