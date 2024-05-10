package com.example.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


private static final String TOPIC = "signupnotificationtopic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendSignupMessage(String message)

    {
    this.kafkaTemplate.send(TOPIC, message);

    }

}
