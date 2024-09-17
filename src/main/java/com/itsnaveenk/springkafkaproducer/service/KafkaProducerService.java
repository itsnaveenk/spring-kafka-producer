package com.itsnaveenk.springkafkaproducer.service;

import com.itsnaveenk.springkafkaproducer.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Notification> kafkaTemplate;

    public void sendMessage(Notification notification) {
        System.out.println("original message reached service " + notification);

        kafkaTemplate.send("foodsOrder", notification);

        System.out.println("Published Successfully");
    }
}
