package com.outdoor.product.service;

import com.outdoor.product.entities.Product;
import com.outdoor.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product){
//        productRepository.save(product);
    }

//    public Product getProductById(Long id){
//        return productRepository.findById(id).orElse(null);
//    }

}
