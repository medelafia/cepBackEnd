package com.med.mailingservice.web;

import com.med.mailingservice.model.SimpleEmailDetails;
import com.med.mailingservice.service.MailingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailingController {
    @Autowired
    private MailingService mailingService ;
    @PostMapping("/sendSimpleEmail")
    public void sendSimpleMail(@RequestBody SimpleEmailDetails simpleEmailDetails) {
        mailingService.sendSimpleMail(simpleEmailDetails) ;
    }
    @PostMapping("/sendMailWithAttachment")
    public void sendMailWithAttachment(){

    }
}
