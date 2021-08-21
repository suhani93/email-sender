package com.example.email.controller;


import com.example.email.request.MailInfoRequest;
import com.example.email.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MailSenderRestController {
    private final MailSenderService mailSenderService;

    @GetMapping("/send")
    public ResponseEntity<?> sendTemplateMail(MailInfoRequest mailInfoRequest) throws Exception {
        mailSenderService.sendTemplateMail(mailInfoRequest);
        return ResponseEntity.ok("");
    }
}
