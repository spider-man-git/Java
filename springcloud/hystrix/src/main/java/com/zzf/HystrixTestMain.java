package com.zzf;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zephyr on 2018/3/7.
 */
@SpringCloudApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class HystrixTestMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTestMain.class);
    }

}
