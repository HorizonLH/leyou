package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hhl
 * @date - 13:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeYouUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeYouUploadApplication.class,args);
    }
}
