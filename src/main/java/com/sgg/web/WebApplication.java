package com.sgg.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.sgg.web.mapper")
@EnableSwagger2
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            // 注意这里要指向原先用main方法执行的Application启动类
            return builder.sources(WebApplication.class);
        }
    }
