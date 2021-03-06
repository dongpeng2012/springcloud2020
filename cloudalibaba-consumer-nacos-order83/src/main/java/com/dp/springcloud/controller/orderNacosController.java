package com.dp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author dp
 * @data 2020/7/11 - 21:08
 */
@RestController
@Slf4j
public class orderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value ("${service-url.nacos-user-service}")
    private String serverUrl;
    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")Long id){
        return restTemplate.getForObject (serverUrl+"/payment/nacos/"+id,String.class);
    }

}
