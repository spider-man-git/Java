package com.zzf.service.impl;

import java.util.Random;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zzf.service.ITestService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zephyr on 2018/3/7.
 */
@Component
public class TestServiceImpl implements ITestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbacktest")
    @Override
    public String testHystrix() {
        int randNum = RandomUtils.nextInt();
        if (randNum % 2 == 1) {
            try {
                Thread.sleep(5000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello";
//        return restTemplate.getForObject("http://service1/test",String.class);
    }

    public String fallbacktest() {
        return "test-duanlule";
    }

}
