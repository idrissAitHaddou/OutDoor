package com.outdoor.product.controller;

import com.outdoor.product.entities.Product;
import com.outdoor.product.service.ProductService;
import com.outdoor.product.shared.ProductRequest;
import com.outdoor.product.shared.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/byId/{id}")
    public ProductResponse getProductById(@PathVariable Long id) throws Exception {
        return productService.getProductById(id);
    }

    @GetMapping("/byName/{name}")
    public ProductResponse getProductByName(@PathVariable String name) throws Exception {
        return productService.getProductByName(name);
    }

    @PutMapping("/edit/{id}/{qte}")
    public ProductResponse editQte(@PathVariable Long id,@PathVariable Long qte) throws Exception {
        return productService.updateQte(id,qte);
    }



}
