package com.zzf.gateway;

import com.zzf.gateway.filter.AddResponseHeaderFilter;
import com.zzf.gateway.filter.QueryParamPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by zephyr on 2018/2/23.
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Gateway {

    @Bean
    public QueryParamPreFilter createQueryParamPreFilter(){
        return new QueryParamPreFilter();
    }

    @Bean
    public AddResponseHeaderFilter createAddResponseHeaderFilter(){
        return new AddResponseHeaderFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Gateway.class,args);
    }
}
