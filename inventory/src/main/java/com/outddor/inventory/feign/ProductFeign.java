package com.outddor.inventory.feign;

import com.outddor.inventory.objects.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product", url = "${spring.port.gatewaye.host}")
public interface ProductFeign {
    @GetMapping("/product")
    List<Product> getProducts();
}
