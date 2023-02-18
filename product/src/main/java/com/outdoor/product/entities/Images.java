package com.outdoor.product.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Getter
@Setter
public class Images {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String url;

    public Images(){
        this.id = UUID.randomUUID().toString().substring(1,4);
    }


}
