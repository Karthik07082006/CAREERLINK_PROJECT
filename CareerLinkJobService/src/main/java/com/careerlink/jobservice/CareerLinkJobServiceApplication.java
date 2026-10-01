package com.careerlink.jobservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CareerLinkJobServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CareerLinkJobServiceApplication.class, args);
    }
}
