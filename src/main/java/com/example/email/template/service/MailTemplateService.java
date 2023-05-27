package com.example.email.template.service;

import com.example.email.template.domain.MailTemplate;
import com.example.email.template.domain.exception.DomainValidationException;
import com.example.email.template.repository.MailTemplateRepository;
import com.example.email.template.repository.exception.DataNotFoundException;
import com.example.email.template.service.dto.MailTemplateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

import static com.example.email.common.utils.ThymeleafValidator.isValidThymeleafExpression;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class MailTemplateService {
    private final MailTemplateRepository mailTemplateRepository;

    public MailTemplateDto getMailTemplate(int id) {
        MailTemplate mailTemplate = mailTemplateRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Mail Template not found with id: " + id));

        return MailTemplateDto.from(mailTemplate);
    }

    public Page<MailTemplateDto> getAllMailTemplates(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<MailTemplateDto> result = mailTemplateRepository.findAll(pageable).map(MailTemplateDto::from);
        return result;
    }

    public int saveMailTemplate(@NotBlank String name,@NotBlank String description,@NotBlank String template) {
        if(isValidThymeleafExpression(template)){
            throw new DomainValidationException("verify the template format");
        };

        MailTemplate mailTemplate = new MailTemplate(name, description, template);
        mailTemplateRepository.save(mailTemplate);

        return mailTemplate.getId();
    }

    public void deleteMailTemplate(int id) {
        mailTemplateRepository.deleteById(id);
    }

}
