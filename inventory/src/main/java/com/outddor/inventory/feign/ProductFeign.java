package com.outddor.inventory.feign;

import com.outddor.inventory.objects.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "product", url = "${spring.port.gatewaye.host}")
public interface ProductFeign {
    @GetMapping("/api/v1/product/getAll")
    List<Product> getProducts();


    @GetMapping("/api/v1/product/byId/{id}")
    Product checkIfExist(@PathVariable Long id);

    @PutMapping("/api/v1/product/edit/{id}/{qte}")
    Product editQte(@PathVariable Long id,@PathVariable Long qte);

}
