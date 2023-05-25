package com.example.email.request;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Map;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MailInfoRequest {
    @NotEmpty
    @Email
    private String mailRecipient;   //메일 받는 사람

    @NotEmpty
    private String mailSender;  //메일 보낸 사람 이름

    @NotEmpty
    private String subject; //메일의 제목

    @NotEmpty
    private String templateId;  // Thymeleaf 템플릿 아이디

    private Map<String, Object> parameters; //Thymeleaf 에서 사용할 값
}
