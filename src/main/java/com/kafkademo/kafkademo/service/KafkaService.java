package com.kafkademo.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public final String TOPIC="demo_topic";

    public void send(String message){
        kafkaTemplate.send(TOPIC,message);
    }
}
