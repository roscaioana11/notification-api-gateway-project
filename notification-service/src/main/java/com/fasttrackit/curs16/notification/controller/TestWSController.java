package com.fasttrackit.curs16.notification.controller;

import com.fasttrackit.curs16.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testws")
@RequiredArgsConstructor
public class TestWSController {
    private final NotificationService notificationService;

    @GetMapping
    void sendws(){
        notificationService.send("test","hello");
    }
}
