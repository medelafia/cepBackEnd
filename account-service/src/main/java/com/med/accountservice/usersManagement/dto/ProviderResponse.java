package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.reviewsManagement.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class ProviderResponse {
    private int id ;
    private String name ;
    private String email ;
    private String webSiteUrl ;
    private String tel ;
    private Image logo ;
    private float score ;
    private int reviewsCount ;
    private String description ;
    private List<Image> images ;
    private String providerType ;
    private String fax ;
}
