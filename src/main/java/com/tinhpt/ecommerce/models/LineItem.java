package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
    private String name;
    private double price;
    private int quantity;
    private String code;
    private String imageUrl;
}
