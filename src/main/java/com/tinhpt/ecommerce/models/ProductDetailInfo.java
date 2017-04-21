package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class ProductDetailInfo {
    private int id;
    private String name;
    private String code;
    private double price;
    private String imageUrl;
    private String description;
    private Date createdDate;
    private BrandModel brand;
    private ProductTypeModel productType;
    private MadeInModel madeIn;
    private int discount;
    private double rating;
    private int quantity;
    private List<CommentResponse> comments;
}
