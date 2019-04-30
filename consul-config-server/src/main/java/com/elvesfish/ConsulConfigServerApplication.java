package com.elvesfish;

import com.elvesfish.consul.config.MyProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({MyProperties.class})
public class ConsulConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigServerApplication.class, args);
    }

}
