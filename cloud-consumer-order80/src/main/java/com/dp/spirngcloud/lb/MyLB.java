package com.dp.spirngcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dp
 * @data 2020/6/20 - 19:03
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger (0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get ();
            next=current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet (current,next));
        System.out.println ("******next:"+next);
        return next;
    }

    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = this.getAndIncrement () % serviceInstances.size ();
        return serviceInstances.get (index);
    }
}
