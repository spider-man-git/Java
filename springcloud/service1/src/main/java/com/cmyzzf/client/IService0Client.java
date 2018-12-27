package com.cmyzzf.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zephyr on 2018/2/24.
 */
@FeignClient("service0")
public interface IService0Client {

    @RequestMapping(method = RequestMethod.GET,path = "test")
    String test();

}
