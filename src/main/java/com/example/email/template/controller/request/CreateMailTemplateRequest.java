package com.example.email.template.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateMailTemplateRequest {
    private String name;
    private String description;
    private String template;
}
