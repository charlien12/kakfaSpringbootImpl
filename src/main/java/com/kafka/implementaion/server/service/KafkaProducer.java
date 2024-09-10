package com.kafka.implementaion.server.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer<T> {

    private static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    public void sendMessage(T message) {
        kafkaTemplate.send(TOPIC, message);
    }

}

