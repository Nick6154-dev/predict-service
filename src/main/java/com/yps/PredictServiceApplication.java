package com.yps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PredictServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredictServiceApplication.class, args);
    }

}
