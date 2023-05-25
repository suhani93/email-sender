package com.example.email.service;

import com.example.email.request.MailInfoRequest;

public interface MailSender {
    void send(MailInfoRequest mailInfoRequest) ;
}
