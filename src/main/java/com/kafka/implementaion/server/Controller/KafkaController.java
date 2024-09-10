package com.kafka.implementaion.server.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kafka.implementaion.server.entity.UsersEntityDto;
import com.kafka.implementaion.server.service.KafkaConsumer;
import com.kafka.implementaion.server.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return kafkaConsumer.getMessages(message).toString();
    }
    @GetMapping(value = "/add",produces = "application/xml")
    public ResponseEntity<?> addUser() throws JsonProcessingException {
        XmlMapper objectMapper = new XmlMapper();
        UsersEntityDto chintan = new UsersEntityDto(1, "chintan", "23");
        String jsonString = objectMapper.writeValueAsString(chintan);
        kafkaProducer.sendMessage(jsonString);
        return new ResponseEntity<>(chintan,HttpStatus.OK);
    }
}

