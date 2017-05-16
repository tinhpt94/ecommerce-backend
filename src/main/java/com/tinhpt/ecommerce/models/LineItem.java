package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
    private String name;
    private double price;
    private int amount;
    private int discount;
    private String code;
    private String imageUrl;
}
