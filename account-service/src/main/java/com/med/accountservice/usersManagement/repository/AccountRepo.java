package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account , Integer> {
    Optional<Account> findByUsername(String username) ;
    Optional<Account> findByEmail(String email) ;
    Optional<Account> findByUsernameOrEmail(String username , String email) ;
}
