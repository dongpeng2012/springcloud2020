package com.dp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author dp
 * @data 2020/6/16 - 22:26
 */
@RestController
@Slf4j
public class OrderZKController {


    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){

       return restTemplate.getForObject (INVOKE_URL+"/payment/zk",String.class);
    }


}
