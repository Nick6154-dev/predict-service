package com.yps.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "periapical-service")
public interface PeriapicalClient {

    @PostMapping("/predict")
    Integer predict(@RequestBody byte[] imageData);

}
