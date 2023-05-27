package com.example.email.sender.service;

import com.example.email.sender.request.MailInfoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Qualifier("kafkaMailSenderSender")
@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMailSenderSender implements MailSender {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String EMAIL_SEND_REQUESTS_TOPIC_NAME = "email_send_requests";

    @Bean
    public NewTopic topic() {

        return TopicBuilder
            .name(EMAIL_SEND_REQUESTS_TOPIC_NAME)
            .build();
    }

    @Override

    public void send(MailInfoRequest mailInfoRequest) {
        try {
            String recode = objectMapper.writeValueAsString(mailInfoRequest);
            kafkaTemplate.send(EMAIL_SEND_REQUESTS_TOPIC_NAME,recode);
        } catch (JsonProcessingException e) {
            log.error("{}",mailInfoRequest, e);
        }

    }
}
