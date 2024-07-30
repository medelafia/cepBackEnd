package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.imagesManagement.entity.Image;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class ProviderRequest extends AccountRequest {
    private String name ;
    private String webSiteUrl ;
    private String fax ;
    private ProviderType providerType ;
    private String address ;
    private String country ;
    private String tel ;
}
