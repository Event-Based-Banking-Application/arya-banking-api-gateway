package org.arya.banking.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AryaBankingApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(org.arya.banking.api.gateway.AryaBankingApiGatewayApplication.class, args);
    }

}
