package com.dp.rabbit.service;


import com.dp.rabbit.bean.Order;
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
//    @RabbitListener(queues = {"world"})
//    public void receiveUserMessage(Message message, Payment payment, Channel channel){
//        System.out.println ("收到的消息是："+message.getClass ());
//        System.out.println (payment);
//        //拒绝掉，再发给别人
//        try {
//            channel.basicReject (message.getMessageProperties ().getDeliveryTag (),false);
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
//    }
    //手动ack
    //接口幂等性，在本地维护一个日志表，那些会员哪些商品哪个订单已经见过库存了，再来同样的消息就不减了
    @RabbitListener(queues = {"order-queue"})
    public void receiveOrder(Order order,Message message,Channel channel) throws IOException {

        System.out.println("监听到新的订单生成");
        Long skuId = order.getSkuId();
        Integer num = order.getNum();
        System.out.println("库存系统正在扣除【"+skuId+"】商品的数量，此次扣除【"+num+"】件");
        if (num%2==0){
            System.out.println("库存系统扣除【"+skuId+"】库存失败");
            //回复消息处理失败并且重新入队
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            throw new RuntimeException("库存扣除失败");
        }
        System.out.println("扣除成功");
        //回复成功,之回复本条消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
    @RabbitListener(queues = {"user.order.queue"})
    public void closeOrder(Order order,Message message,Channel channel) throws IOException, InterruptedException {
        System.out.println("收到过期订单："+order);
//        Thread.currentThread().sleep(2000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}
