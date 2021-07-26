package com.fasttrackit.curs16.notification.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
    @Bean
    DirectExchange studentExchange() {
        return new DirectExchange("students.exchange");
    }

    @Bean
    Queue studentQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding binding(Queue studentQueue, DirectExchange studentExchange) {
        return BindingBuilder.bind(studentQueue).to(studentExchange).with("student");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
