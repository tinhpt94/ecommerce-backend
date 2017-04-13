package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModal {
    private int id;
    private String name;
    private double price;
    private String imageUrl;
}
