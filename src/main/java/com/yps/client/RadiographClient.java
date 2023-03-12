package com.yps.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "radiograph-service")
public interface RadiographClient {

    @PostMapping("/validate")
    Integer validate(@RequestBody byte[] imageData);

}
