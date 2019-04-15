package com.elvesfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(MsClient1Application.class, args);
    }

}
