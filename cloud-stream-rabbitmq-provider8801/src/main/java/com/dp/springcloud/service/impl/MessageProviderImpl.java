package com.dp.springcloud.service.impl;

import com.dp.springcloud.service.IMessageProvider;
import org.springframework.amqp.core.Message;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author dp
 * @data 2020/7/2 - 21:18
 */
@EnableBinding(Source.class)//消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    public String send() {

        String serial = UUID.randomUUID ().toString ();
        output.send (MessageBuilder.withPayload (serial).build ());
        System.out.println ("serial"+serial);
        return null;
    }
}
