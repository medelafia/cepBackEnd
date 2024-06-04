package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session , String> {
}
