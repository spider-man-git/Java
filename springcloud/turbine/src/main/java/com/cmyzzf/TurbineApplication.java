package com.cmyzzf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class TurbineApplication {
}
