package com.example.email.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class MailInfoRequest {
    private String mailRecipient;   //메일 받는 사람
    private String mailSender;  //메일 보낸 사람 이름
    private String subject; //메일의 제목
    private Map<String, Object> parameters; //Thymeleaf 에서 사용할 값
    private String templateId;  // Thymeleaf 템플릿 아이디
}
