package com.elvesfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(MsClient2Application.class, args);
    }

}
