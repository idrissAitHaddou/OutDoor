package com.outddor.inventory.feign;

import com.outddor.inventory.config.FeignClientConfiguration;
import com.outddor.inventory.objects.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client", url = "http://localhost:8082", configuration = FeignClientConfiguration.class)
public interface UserFeign {
    @Headers("Content-Type: application/json")
    @GetMapping("/api/v1/user/load-by-email")
    User getUserByEmail(String email);
}
