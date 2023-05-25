package com.example.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailSenderController {
    @GetMapping("")
    public String viewForm()  {
        return "main/form";
    }
}
