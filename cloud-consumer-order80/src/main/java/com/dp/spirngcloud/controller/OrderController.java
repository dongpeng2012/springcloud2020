package com.dp.spirngcloud.controller;

import com.dp.spirngcloud.lb.LoadBalancer;
import com.dp.springcloud.entities.CommonResult;
import com.dp.springcloud.entities.Payment;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL="http://cloud-payment-service";
    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity (PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode ().is2xxSuccessful ()){
            return entity.getBody ();
        }else {
            return new CommonResult (444,"操作失败");
        }
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances ("cloud-payment-service");
        if (Objects.isNull(instances)){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.instances (instances);
        URI uri = serviceInstance.getUri ();
        return restTemplate.getForObject (uri+"/payment/lb",String.class);

    }

}
