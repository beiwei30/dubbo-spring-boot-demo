package com.example.dubbofilterdemo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DubboFilterDemoApplication {

    @Reference(version = "1.0.0")
    private HelloService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboFilterDemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String sayHello = demoService.sayHello("world");
        System.err.println(sayHello);
    }
}
