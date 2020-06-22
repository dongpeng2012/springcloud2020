package com.dp.springcloud.controller;

import com.dp.springcloud.entities.CommonResult;
import com.dp.springcloud.entities.Payment;
import com.dp.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dp
 * @data 2020/6/21 - 14:27
 */
@RestController
@Slf4j
public class OpenFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById (id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeOut")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut ();
    }



}
