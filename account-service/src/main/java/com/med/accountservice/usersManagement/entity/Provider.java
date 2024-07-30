package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.imagesManagement.entity.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@SuperBuilder
public class Provider extends Account {
    private String name ;
    private String webSiteUrl ;
    private String fax ;
    private String country ;
    private String address ;
    private String tel ;
    private String description ;
    @OneToOne
    private Image logo ;
    @Transient
    private int nbReviews ;
    @Transient
    private float score ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Image> images ;
    public Provider(Provider provider) {
        this.setUsername(provider.getUsername());
        this.setPassword(provider.getPassword());
        this.setName(provider.getName());
        this.setRegisterByGoogle(provider.isRegisterByGoogle());
        this.setImages(provider.getImages());
        this.setFax(provider.getFax());
        this.setEmail(provider.getEmail());
        this.setEmail(provider.getEmail());
        this.setAddress(provider.getAddress());
        this.setWebSiteUrl(provider.getWebSiteUrl());
        this.setRole(provider.getRole());
        this.setLogo(provider.getLogo());
    }
    @Override
    public Account login(String username, String password) {
        return null;
    }

    @Override
    public Account register(Account account) {
        return null;
    }
    public Provider changeLogo(Image newLogo) {
        this.logo = newLogo  ;
        return this ;
    }
    public Provider addImages(List<Image> images) {
        this.getImages().addAll(images) ;
        return this ;
    }
}
