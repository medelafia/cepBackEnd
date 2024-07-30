package com.med.accountservice.usersManagement.mapper;

import com.med.accountservice.usersManagement.dto.AdminResponse;
import com.med.accountservice.usersManagement.entity.Admin;

public class AdminMapper {
    public static AdminResponse toAdminResponse(Admin admin) {
        return AdminResponse.builder()
                .id(admin.getId())
                .email(admin.getEmail())
                .build() ;
    }
}
