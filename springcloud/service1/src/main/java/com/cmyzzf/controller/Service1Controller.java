package com.cmyzzf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zephyr on 2018/2/24.
 */
@RestController
public class Service1Controller {

//    @ApiOperation()
    @GetMapping("/test")
    public String test() {
        return "service1";
    }
}
