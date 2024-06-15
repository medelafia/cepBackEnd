package com.med.accountservice.usersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.usersManagement.model.RecommendationProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
public class Costumer extends Account {
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
    private boolean recommendationProfileActivation ;
    @JsonIgnore
    private int recommendationProfileId ;
    @Transient
    private RecommendationProfile recommendationProfile ;
    @OneToOne
    private Image profileImage ;

    @Override
    public Account login(String username, String password) {
        return null;
    }

    @Override
    public Account register(Account account) {
        return null;
    }
    public void activateRecommendation() {
        this.setRecommendationProfileActivation(true);
    }
    public void stopRecommendation(){
        this.setRecommendationProfileActivation(false);
    }
    public Costumer updateInfo(Costumer costumer) {
        this.age = costumer.getAge()  ;
        this.firstName = costumer.getFirstName() ;
        this.lastName = costumer.getLastName() ;
        this.gender = costumer.getGender() ;
        return this ;
    }
    public Image changeProfileImage(Image image) {
        this.setProfileImage(image) ;
        return this.profileImage ;
    }
}
