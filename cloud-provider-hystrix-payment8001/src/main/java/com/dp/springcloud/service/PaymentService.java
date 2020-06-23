package com.dp.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class PaymentService {

    public String paymentInfoOK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfoOK,  id:"+id+"\t 0.0";
    }
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoTimeOut(Integer id){
        int timeOut=7;
//        int age=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfoTimeOut,  id:"+id+"\t 0.0"+"耗时"+timeOut+"秒";
    }
    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"系统繁忙或运行报错，请稍后在试,  id:"+id+"\t T.T";
    }
}
