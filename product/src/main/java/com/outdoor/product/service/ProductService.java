package com.outdoor.product.service;

import com.outdoor.product.entities.Product;
import com.outdoor.product.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product){
        Date date = new Date();
        product.setCreatedAt(date);
        productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProduct(){
        return Lists.newArrayList(productRepository.findAll());
    }


}
