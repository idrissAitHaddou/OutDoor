package com.outdoor.product.shared;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductResponse {

    private String id;

    private String name;

    private String description;

    private Long qte;

    private Date createdAt;

    private List<ImagesResponse> images;

}
