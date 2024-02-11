package com.wk.demozh.springdbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.wk.demozh.springdbapi.entity", "com.wk.demozh.springdbapi.repository", "com.wk.demozh.springdbapi.serivce" })
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}, scanBasePackages = "com.wk.demozh.springdbapi")
public class SpringCompareDbApiDemozhApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCompareDbApiDemozhApplication.class, args);
    }

}
