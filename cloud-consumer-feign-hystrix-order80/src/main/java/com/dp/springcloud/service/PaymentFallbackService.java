package com.dp.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    public String paymentInfoOK(Integer id) {
        return "PaymentFallbackService fall back paymentInfoOK T_T";
    }

    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService fall back paymentInfoTimeOut T_T";
    }
}
