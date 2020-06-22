package com.dp.rabbit.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dp
 * @data 2020/6/18 - 23:18
 */
@Configuration
public class RabbiltDeadDelayConfig {
    /**
     * 一个普通的交换机
     * @return
     */
    @Bean
    public Exchange delayExchange(){
        return new DirectExchange ("user.order.delay.exchange",true,false);
    }
    @Bean
    public Queue delayQueue(){

        Map<String,Object> arguments=new HashMap<> ();
        arguments.put ("x-message-ttl",10*1000);
        arguments.put ("x-dead-letter-exchange","user.order.exchange");//消息死了交给哪个交换机
        arguments.put ("x-dead-routing-key","order");//路由键

        return new Queue ("user.order.delay.queue",true,false,false,arguments);
    }

    @Bean
    public Binding delayBinding(){
        return new Binding ("user.order.delay.queue", Binding.DestinationType.QUEUE,"user.order.delay.exchange",
                "order_delay",null);
    }
    @Bean
    public Exchange deadExchange(){
        return new DirectExchange ("user.order.exchange",true,false);
    }
    @Bean
    public Queue deadQueue(){

        return new Queue ("user.order.queue",true,false,false);
    }
    @Bean
    public Binding deadBinding(){
        return new Binding ("user.order.queue", Binding.DestinationType.QUEUE,"user.order.exchange",
                "order",null);
    }


}
