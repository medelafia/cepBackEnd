package com.med.accountservice.usersManagement.mapper;

import com.med.accountservice.usersManagement.dto.CostumerResponse;
import com.med.accountservice.usersManagement.entity.Costumer;

public class CostumerMapper {
    public static CostumerResponse toCostumerResponse(Costumer costumer){
        return CostumerResponse.builder()
                .id(costumer.getId())
                .firstName(costumer.getFirstName())
                .lastName(costumer.getLastName())
                .gender(costumer.getGender())
                .age(costumer.getAge())
                .profile(costumer.getProfileImage())
                .build() ;
    }
}
