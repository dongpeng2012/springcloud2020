package com.dp.rabbit.service;


import com.dp.springcloud.entities.Payment;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @author dp
 * @data 2020/6/18 - 0:07
 */
@Service
public class UserService {
    @RabbitListener(queues = {"world"})
    public void receiveUserMessage(Message message, Payment payment, Channel channel){
        System.out.println ("收到的消息是："+message.getClass ());
        System.out.println (payment);
        //拒绝掉，再发给别人
        try {
            channel.basicReject (message.getMessageProperties ().getDeliveryTag (),true);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}
