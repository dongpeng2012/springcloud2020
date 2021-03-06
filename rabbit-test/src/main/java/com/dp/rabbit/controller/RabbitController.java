package com.dp.rabbit.controller;

import com.dp.rabbit.bean.Order;
import com.dp.springcloud.entities.Payment;
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

import java.util.UUID;

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
//        rabbitTemplate.convertAndSend ("direct_exchange","world",payment);

        rabbitTemplate.convertAndSend ("user.order.delay.exchange","order_delay",payment);
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
    @RequestMapping("/create/order")
    public Order createOrder(Long skuId,Integer num,Integer memberId){
        Order order = new Order(UUID.randomUUID().toString().replace("-", ""), skuId, num, memberId);
//        rabbitTemplate.convertAndSend("order-exchange","createOrder",order);
        rabbitTemplate.convertAndSend("user.order.delay.exchange","delay_order",order);
        return order;
    }






}
