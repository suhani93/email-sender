package com.example.email.controller;

import com.example.email.request.MailInfoRequest;
import com.example.email.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MailSenderRestController {
    private final MailSenderService mailSenderService;

    @GetMapping("/test")
    public String as(){
        return "aaaa";
    }

    @GetMapping("/send")
    public ResponseEntity<?> sendTemplateMail(@Valid MailInfoRequest mailInfoRequest) throws Exception {
        mailSenderService.sendTemplateMail(mailInfoRequest);
        return ResponseEntity.ok("");
    }
}
