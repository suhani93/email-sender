package com.example.email.template.service.dto;

import com.example.email.template.domain.MailTemplate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MailTemplateDto {
    private int id;
    private String name;
    private String description;
    private String template;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static MailTemplateDto from(MailTemplate mailTemplate){

        MailTemplateDto mailTemplateDto = new MailTemplateDto();
        mailTemplateDto.id = mailTemplate.getId();
        mailTemplateDto.name = mailTemplate.getName();
        mailTemplateDto.description = mailTemplate.getDescription();
        mailTemplateDto.template = mailTemplate.getTemplate();
        mailTemplateDto.createdAt = mailTemplate.getCreatedAt();
        mailTemplateDto.modifiedAt = mailTemplate.getModifiedAt();
        return mailTemplateDto;
    }
}
