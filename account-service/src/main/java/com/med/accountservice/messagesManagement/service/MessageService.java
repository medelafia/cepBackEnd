package com.med.accountservice.messagesManagement.service;

import com.med.accountservice.messagesManagement.entity.Message;
import com.med.accountservice.messagesManagement.repository.MessageRepo;
import lombok.Setter;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo ;
    public Message send(Message message) {
        return messageRepo.save(Message.builder()
                        .content(message.getContent())
                        .email(message.getEmail())
                        .date(Date.valueOf(LocalDate.now()))
                        .unRead(true)
                .build())  ;
    }
    public List<Message> getAllNotReadMessages() {
        return messageRepo.findAllByUnRead(true) ;
    }
    public List<Message> getAllMessages() {
        return messageRepo.findAll() ;
    }
    public List<Message> getNewMessages() {
        return messageRepo.findAllByDateAndUnRead(Date.valueOf(LocalDate.now()) , true) ;
    }
}
