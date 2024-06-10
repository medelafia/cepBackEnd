package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.ResetPasswordSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordSessionRepository  extends JpaRepository<ResetPasswordSession , String> {
}
