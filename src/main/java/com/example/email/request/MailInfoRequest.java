package com.example.email.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class MailInfoRequest {
    private String mailRecipient;
    private String mailSender;
    private String subject;
    private Map<String, Object> parameters;
    private String templateId;
}
