package com.med.mailingservice.service;

import com.med.mailingservice.model.SimpleEmailDetails;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailingService {

    private JavaMailSender javaMailSender ;
    public MailingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender ;
    }
    public void sendSimpleMail(SimpleEmailDetails simpleEmailDetails) {
        if(simpleEmailDetails.getMsg() == null || simpleEmailDetails.getTo() == null || simpleEmailDetails.getSubject() == null) {
            System.out.println("invalid data");
        }else {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage() ;
            simpleMailMessage.setFrom("mohamedelafia723@gmail.com");
            simpleMailMessage.setTo(simpleEmailDetails.getTo());
            simpleMailMessage.setSubject(simpleEmailDetails.getSubject());
            simpleMailMessage.setText(simpleEmailDetails.getMsg());
            javaMailSender.send(simpleMailMessage) ;
        }
    }
}
