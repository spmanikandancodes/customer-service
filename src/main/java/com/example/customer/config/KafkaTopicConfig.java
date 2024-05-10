package com.example.customer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.signupnotification}")
    private String signupT;

    @Value("${spring.kafka.topic.bookingnotification}")
    private String bookingT;



    public NewTopic topic() {
        return TopicBuilder.name(signupT)
                .build();
    }


    public NewTopic topicBooking() {
        return TopicBuilder.name(bookingT)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
