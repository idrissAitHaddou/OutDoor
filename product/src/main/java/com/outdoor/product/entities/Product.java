package com.outdoor.product.entities;

import com.outdoor.product.helper.Indices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(indexName = Indices.PRODUCT_INDEX)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type=FieldType.Integer)
    private Long qte;
    @Field(type = FieldType.Date)
    private Date createdAt;

    @Field(type = FieldType.Nested)
    private List<Images> images;
}
