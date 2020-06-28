package com.dp.springcloud.controller;


import com.dp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOK(id);
        log.info("*******"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
//        int i =10/0;
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("*******"+result);
        return result;
    }

}
