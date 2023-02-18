package com.outdoor.product.service;

import com.outdoor.product.entities.Product;
import com.outdoor.product.repository.ProductRepository;
import com.outdoor.product.shared.ProductRequest;
import com.outdoor.product.shared.ProductResponse;
import org.assertj.core.util.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productRequest, Product.class);
        BeanUtils.copyProperties(productRequest,product);
        Date date = new Date();
        product.setCreatedAt(date);
        productRepository.save(product);
    }

    public ProductResponse getProductById(Long id) throws Exception {
        Product product = productRepository.findById(id).orElse(null);
        if (!(product instanceof Product)) throw new Exception("Product does id "+id+" not found");
        return EntityToResponse(product);
    }

    public List<ProductResponse> getAllProduct(){
        List<Product> products = Lists.newArrayList(productRepository.findAll());
        ModelMapper modelMapper = new ModelMapper();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product:products) {
            ProductResponse productResponse = modelMapper.map(product,ProductResponse.class);
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    public ProductResponse getProductByName(String name) throws Exception {
        Product product = productRepository.findByName(name);
        if(!(product instanceof Product)) throw new Exception("Product does name "+name+" not found");
        return EntityToResponse(product);
    }

    public ProductResponse EntityToResponse(Product product){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductResponse.class);
    }

    public ProductResponse updateQte(Long id,Long qte) throws Exception {
        Product product = productRepository.findById(id).orElse(null);
        if(!(product instanceof Product)) throw new Exception("Product does id "+id+" not found");
        product.setQte(qte);
        Product productResponse = productRepository.save(product);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productResponse, ProductResponse.class);
    }

}
