package com.outddor.inventory.objects;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private Long qte;
    private Date createdAt;
    private List<Images> images;

}
