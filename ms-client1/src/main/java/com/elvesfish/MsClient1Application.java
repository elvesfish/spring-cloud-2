package com.elvesfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class MsClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(MsClient1Application.class, args);
    }

}
