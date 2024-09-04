package com.itsnaveenk.springkafkaproducer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class WebController {

    @GetMapping("/")
    public String check() {
        System.out.println("check success. printed in console");
        return "Test Success";
    }

    @PostMapping("/send")
    public ResponseEntity<String> send() {
        return ResponseEntity.ok("Message sent successfully");
    }
}
