package com.outdoor.order.feign;

import com.outdoor.order.config.FeignClientConfiguration;
import com.outdoor.order.objects.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client", url = "http://localhost:8082", configuration = FeignClientConfiguration.class)
public interface UserFeign {
    @Headers("Content-Type: application/json")
    @GetMapping("/api/v1/user/load-by-email")
    User getUserByEmail(String email);
}
