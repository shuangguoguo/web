package com.sgg.web.support;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sgg.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(enable);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("爽蝈蝈个人博客接口文档")
                .termsOfServiceUrl("http://")
                .version("1.0")
                .build();
    }
}
