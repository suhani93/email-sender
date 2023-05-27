package com.example.email.sender.service;

import com.example.email.sender.request.MailInfoRequest;

public interface MailSender {
    void send(MailInfoRequest mailInfoRequest) ;
}
