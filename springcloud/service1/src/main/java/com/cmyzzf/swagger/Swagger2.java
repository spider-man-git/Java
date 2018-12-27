package com.cmyzzf.swagger;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by zephyr on 2018/2/6.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
//@ComponentScan(basePackages = {"ccmyzzf.controller"})
public class Swagger2{


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cmyzzf.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Bookroom Test Swagger2 For RESTful APIs")
                .description("测试")
                .contact("zzfzjf@gmail.com")
                .version("1.0")
                .build();
    }





}
