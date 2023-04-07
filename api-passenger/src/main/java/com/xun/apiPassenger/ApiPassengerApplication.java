package com.xun.apiPassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author slx
 * @ClassName ApiPassengerApplication
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiPassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class);
    }
}
