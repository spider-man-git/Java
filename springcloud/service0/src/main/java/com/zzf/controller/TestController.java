package com.zzf.controller;

import com.zzf.service.ITestService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zephyr on 2018/3/7.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/hystrix")
    public String test(){
        int i = RandomUtils.nextInt(10);
        String result =null;
        try {
            result = testService.testHystrix();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        int j=2;
        System.out.println(i+j);
        return result;
    }


}
