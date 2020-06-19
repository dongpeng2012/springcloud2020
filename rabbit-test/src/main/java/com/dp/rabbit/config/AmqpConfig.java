package com.dp.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dp
 * @data 2020/6/18 - 0:01
 */
@Configuration
public class AmqpConfig {
    @Bean
    public Queue helloQueue(){
        return new Queue("order-queue",true,false,false,null);
    }
    @Bean
    public Exchange orderExchange(){
        return new DirectExchange("order-exchange",true,false);
    }
    @Bean
    public Binding orderBinding(){
        return new Binding("order-queue", Binding.DestinationType.QUEUE,"order-exchange","createOrder",null);
    }


}
