package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hhl
 * @date - 20:55
 */
@SpringBootApplication
@EnableEurekaServer
public class LeYouRegistryApplication {


    public static void main(String[] args) {
        SpringApplication.run(LeYouRegistryApplication.class,args);
    }

}
