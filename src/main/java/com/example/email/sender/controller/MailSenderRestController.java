package com.example.email.sender.controller;

import com.example.email.sender.request.MailInfoRequest;
import com.example.email.sender.service.MailSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class MailSenderRestController {
    private final MailSender mailSender;

    public MailSenderRestController(@Qualifier("kafkaMailSenderSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping(value = "/send",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendTemplateMail(@Valid @RequestBody MailInfoRequest mailInfoRequest) {
        mailSender.send(mailInfoRequest);
        return ResponseEntity.ok(mailInfoRequest);
    }
}
