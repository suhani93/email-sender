package com.example.email.template.controller;


import com.example.email.common.controller.response.ResponseData;
import com.example.email.template.controller.request.CreateMailTemplateRequest;
import com.example.email.template.service.MailTemplateService;
import com.example.email.template.service.dto.MailTemplateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mail-templates",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MailTemplateRestController {
    private final MailTemplateService mailTemplateService;

    @GetMapping("/{id}")
    public ResponseData<?> getMailTemplateById(@PathVariable("id") int id) {
        MailTemplateDto result = mailTemplateService.getMailTemplate(id);
        return ResponseData.success(result);
    }

    @GetMapping
    public ResponseData<?> getAllMailTemplates(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<MailTemplateDto> result = mailTemplateService.getAllMailTemplates(page, size);
        return ResponseData.success(result);
    }

    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<?> createMailTemplate(@RequestBody CreateMailTemplateRequest request) {
        int id = mailTemplateService.saveMailTemplate(request.getName(), request.getDescription(), request.getTemplate());
        return ResponseData.success(id);
    }


    @DeleteMapping("/{id}")
    public ResponseData<?> deleteMailTemplate(@PathVariable("id") int id) {
        mailTemplateService.deleteMailTemplate(id);
        return ResponseData.success(id);
    }
}
