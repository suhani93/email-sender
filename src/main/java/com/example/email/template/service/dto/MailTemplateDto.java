package com.example.email.template.service.dto;

import com.example.email.template.domain.MailTemplate;
import com.example.email.template.domain.TemplateParameter;
import java.util.List;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MailTemplateDto {
    private int id;
    private String name;
    private String description;
    private String template;
    private List<TemplateParameter> templateParameters;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static MailTemplateDto from(MailTemplate mailTemplate){

        MailTemplateDto mailTemplateDto = new MailTemplateDto();
        mailTemplateDto.id = mailTemplate.getId();
        mailTemplateDto.name = mailTemplate.getName();
        mailTemplateDto.description = mailTemplate.getDescription();
        mailTemplateDto.template = mailTemplate.getTemplate();
        mailTemplateDto.templateParameters = mailTemplate.getTemplateParameters();
        mailTemplateDto.createdAt = mailTemplate.getCreatedAt();
        mailTemplateDto.modifiedAt = mailTemplate.getModifiedAt();
        return mailTemplateDto;
    }
}
