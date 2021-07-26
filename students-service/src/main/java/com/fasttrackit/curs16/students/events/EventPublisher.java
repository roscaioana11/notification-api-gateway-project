package com.fasttrackit.curs16.students.events;

import com.fasttrackit.curs16.students.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange studentExchange;

    public void sendStudentAddedEvent(Student student) {
        log.info("Sending " + student + " on route student");
        rabbitTemplate.convertAndSend(studentExchange.getName(), "student", student);
    }
}
