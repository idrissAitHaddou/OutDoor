package com.outdoor.product.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Document(indexName = "products")
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type=FieldType.Integer)
    private Long qte;
    @Field(type = FieldType.Date)
    private Date createdAt;

    @Field(type = FieldType.Nested)
    private List<Images> images;

    public Product(){
        this.id = UUID.randomUUID().toString().substring(0,4);
    }


}
