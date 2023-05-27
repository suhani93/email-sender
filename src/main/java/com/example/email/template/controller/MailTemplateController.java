package com.example.email.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailTemplateController {
    @GetMapping("")
    public String viewForm()  {
        return "main/template";
    }
}
