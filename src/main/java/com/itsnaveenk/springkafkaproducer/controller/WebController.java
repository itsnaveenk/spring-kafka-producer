package com.itsnaveenk.springkafkaproducer.controller;

import com.itsnaveenk.springkafkaproducer.model.Notification;
import com.itsnaveenk.springkafkaproducer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WebController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @GetMapping("/")
    public String check() {
        System.out.println("check success. printed in console");
        return "Test Success";
    }


    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody Notification notification) {
        System.out.println(notification.getMessage() + "received in system");
        try {
            kafkaProducerService.sendMessage(notification);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("service not working");
        }
        return ResponseEntity.ok("Message sent successfully");
    }
}
