package com.example.sophistcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MyNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNacosApplication.class, args);
    }
}
