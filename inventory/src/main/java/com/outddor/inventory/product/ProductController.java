package com.outddor.inventory.product;

import com.outddor.inventory.feign.ProductFeign;
import com.outddor.inventory.objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class ProductController {
    @Autowired
    ProductFeign productFeign;
    @GetMapping("/product")
    public List<Product> getProducts() {
        return productFeign.getProducts();
    }
}
