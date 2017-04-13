package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private int id;
    private String name;
    private double price;
    private String imageUrl;
    private String description;
    private int brand;
    private int productType;
    private int madeIn;
    private int discount;
    private double rating;
    private int quantity;
}
