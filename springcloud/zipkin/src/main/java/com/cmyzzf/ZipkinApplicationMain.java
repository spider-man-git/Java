package com.cmyzzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZipkinApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplicationMain.class);
    }

}
