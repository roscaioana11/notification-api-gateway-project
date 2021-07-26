package com.fasttrackit.curs16.notification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    public void send(Object message) {
        log.info("Sending " + message);
        messagingTemplate.convertAndSend("student.add", message);
    }
}
