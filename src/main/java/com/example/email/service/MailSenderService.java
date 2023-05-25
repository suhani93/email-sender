package com.example.email.service;

import com.example.email.request.MailInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Qualifier("MailSenderSender")
@Service
@RequiredArgsConstructor
public class MailSenderService implements MailSender {
    private final MailProperties mailProperties;
    private final TemplateEngine templateEngine;
    private final JavaMailSenderImpl mailSender;

    @Override
    public void send(MailInfoRequest mailInfoRequest) {
        Context context = new Context();
        context.setVariables(mailInfoRequest.getParameters());

        try {
            InternetAddress from = new InternetAddress(mailProperties.getUsername(), mailInfoRequest.getMailSender());
            InternetAddress to = new InternetAddress(mailInfoRequest.getMailRecipient());

            String htmlTemplate = templateEngine.process(mailInfoRequest.getTemplateId(), context);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(mailInfoRequest.getSubject());
            messageHelper.setText(htmlTemplate, true);

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new RuntimeException();
        }



    }

}
