package com.dp.spirngcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate GetRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ExecutorService executorService(){
        return new ThreadPoolExecutor(5,
                Runtime.getRuntime().availableProcessors()*2,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
