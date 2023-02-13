package com.outdoor.product.entities;

import com.outdoor.product.helper.Indices;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

@Getter
@Setter

@Document(indexName = "products")
@Setting(settingPath = "static/es-settings.json")
public class Product {

    @Id
    @Field(type = FieldType.Auto)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type=FieldType.Integer)
    private Long qte;
    @Field(type = FieldType.Date)
    private Date createdAt;

}
