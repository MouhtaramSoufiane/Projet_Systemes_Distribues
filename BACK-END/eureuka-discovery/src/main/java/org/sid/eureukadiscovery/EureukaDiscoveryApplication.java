package org.sid.eureukadiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureukaDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureukaDiscoveryApplication.class, args);
    }

}
