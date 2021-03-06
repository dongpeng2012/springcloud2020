package com.dp.springcloud.service;

import com.dp.springcloud.entities.CommonResult;
import com.dp.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dp
 * @data 2020/6/21 - 14:18
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);
    @GetMapping(value = "/payment/feign/timeOut")
    String paymentFeignTimeOut();

}
