package com.example.email.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Setter
@Getter
public class MailInfoRequest {
    @NotEmpty(message = "mailRecipient cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "mailRecipient format is not correct")
    private String mailRecipient;   //메일 받는 사람
    @NotEmpty(message = "mailSender cannot be empty")
    private String mailSender;  //메일 보낸 사람 이름
    private String subject; //메일의 제목
    private Map<String, Object> parameters; //Thymeleaf 에서 사용할 값
    @NotEmpty(message = "templateId is not empty")
    private String templateId;  // Thymeleaf 템플릿 아이디
}
