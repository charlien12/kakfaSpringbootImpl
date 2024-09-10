package com.kafka.implementaion.server.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {
    private final List<String> messages = new ArrayList<>();
    @KafkaListener(topics = "my_topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Consumed message: " + message);
    }
    public List<String> getMessages(String message) {
        messages.add(message);
            return new ArrayList<>(messages); // Return a copy of the messages

    }
    public void clearMessages() {

            messages.clear();
        
    }
}
