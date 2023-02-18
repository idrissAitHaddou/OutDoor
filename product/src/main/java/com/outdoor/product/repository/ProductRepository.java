package com.outdoor.product.repository;

import com.outdoor.product.entities.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product,Long> {
    Product findByName(String name);
}
