package com.itsnaveenk.springkafkaproducer.service;

import com.itsnaveenk.springkafkaproducer.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Notification notification) {
        System.out.println("original message reached service" + notification);
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("foodsOrder", notification);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + notification.toString()
                        +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        notification.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
