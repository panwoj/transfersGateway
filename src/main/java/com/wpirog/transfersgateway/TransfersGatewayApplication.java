package com.wpirog.transfersgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableDiscoveryClient
@EnableKafka
@EnableFeignClients
@SpringBootApplication
public class TransfersGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransfersGatewayApplication.class, args);
    }

}
