package com.outdoor.product.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
public class Images {

    @Id
    @Field(type=FieldType.Integer)
    private Long id;

    @Field(type = FieldType.Text)
    private String url;


}
