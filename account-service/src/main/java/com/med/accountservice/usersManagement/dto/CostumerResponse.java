package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.imagesManagement.entity.Image;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class CostumerResponse {
    private int id ;
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
    private Image profile ;
}
