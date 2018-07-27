package com.github.charlesvhe.springfox.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoAutoConfiguration {
    @Bean
    public Docket docket(@Value("${swagger.enable:true}") boolean enableSwagger) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("DEMO")
                                .description("演示swagger共用model区分group")
                                .version("v1")
                                .build())
                .select().apis(RequestHandlerSelectors.basePackage(DemoAutoConfiguration.class.getPackage().getName()))
                .build()
                .enable(enableSwagger);
        return docket;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoAutoConfiguration.class, args);
    }
}
