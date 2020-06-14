package com.dp.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author dp
 * @data 2020/6/14 - 22:53
 */
@SpringBootApplication
@EnableRabbit
public class RabbitTestApplication {
    public static void main(String[] args) {
        SpringApplication.run (RabbitTestApplication.class, args);
    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter ();
    }
}
