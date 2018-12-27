package com.zzf;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zephyr on 2018/2/23.
 */
@RestController
@SpringCloudApplication
public class Service0 {

//    @Value("${cmyzzf}")
    private String zzf;

    @GetMapping("/service0")
    public String service0(){
        System.out.println("hello");
        return "service0"+zzf;
    }

    public static void main(String[] args) {
        SpringApplication.run(Service0.class,args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
//        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new   SimpleClientHttpRequestFactory();
//        simpleClientHttpRequestFactory.setConnectTimeout(100);
//        simpleClientHttpRequestFactory.setReadTimeout(100);
//        return new RestTemplate(simpleClientHttpRequestFactory);
        return new RestTemplate();
    }


}
