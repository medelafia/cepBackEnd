package com.med.accountservice.usersManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class CostumerRequest extends  AccountRequest{
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
}
