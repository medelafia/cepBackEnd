package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin , Integer> {
    public Optional<Admin> findByUsername(String username) ;
}
