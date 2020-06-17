package com.dp.rabbit.controller;

import com.dp.rabbit.bean.User;
import com.dp.springcloud.entities.Payment;
import com.rabbitmq.client.AMQP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    AmqpAdmin amqpAdmin;
    @GetMapping(value = "/test")
    public void test(){
        Payment payment = new Payment (50L, "李白");
//        rabbitTemplate.setMessageConverter (new Jackson2JsonMessageConverter ());
//        User user = new User ("zs","zhangsan@qq.com");
        rabbitTemplate.convertAndSend ("direct_exchange","world",payment);
        log.info ("消息发送完成!");
    }
    @RequestMapping(value = "/createQueue")
    public void createQueue(){
        //是否持久化，是否排他，是否自动删除
        Queue queue = new Queue ("my-queue-01",true,false,false);
        amqpAdmin.declareQueue (queue);

        System.out.println ("队列创建完成");

    }
    @RequestMapping(value = "/createExchange")
    public void createExchange(){
        DirectExchange directExchange = new DirectExchange ("my-exchange", true, false);
        amqpAdmin.declareExchange (directExchange);
        System.out.println ("交换机创建完成");
    }
    @RequestMapping(value = "/createBinding")
    public void createBinding(){
        Binding binding = new Binding ("my-queue-01", Binding.DestinationType.QUEUE,"my-exchange","hello",null);
        amqpAdmin.declareBinding (binding);
        System.out.println ("绑定创建完成");
    }

}
