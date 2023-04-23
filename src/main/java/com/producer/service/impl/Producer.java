package com.producer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer.model.Twitter;

@Component
public class Producer {

	@Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(List<Twitter> twittes) throws JsonProcessingException {
        String twitterAsMessage = objectMapper.writeValueAsString(twittes);
        kafkaTemplate.send(orderTopic, twitterAsMessage);

        System.out.println("Twitter message "+ twitterAsMessage);

        return "message sent";
    }
}
