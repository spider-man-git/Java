package com.cmyzzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zephyr on 2018/2/23.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Service1 {

    public static void main(String[] args) {
        SpringApplication.run(Service1.class,args);
    }


}
