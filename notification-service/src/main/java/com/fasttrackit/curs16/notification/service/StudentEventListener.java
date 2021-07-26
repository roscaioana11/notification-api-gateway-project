package com.fasttrackit.curs16.notification.service;

import com.fasttrackit.curs16.notification.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentEventListener {
    private final NotificationService notificationService;

    @RabbitListener(queues = "#{studentQueue.name}")
    void processStudentEvent(Student event) {
        log.info("Received event " + event);
        notificationService.send(event);
    }
}
