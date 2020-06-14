package com.dp.rabbit.controller;

import com.dp.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dp
 * @data 2020/6/14 - 23:06
 */
@RestController
@Slf4j
public class RabbitController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @GetMapping(value = "/test")
    public void test(){
        Payment payment = new Payment (50L, "李白");
//        rabbitTemplate.setMessageConverter (new Jackson2JsonMessageConverter ());
        rabbitTemplate.convertAndSend ("direct_exchange","world",payment);
        log.info ("消息发送完成!");
    }

}
