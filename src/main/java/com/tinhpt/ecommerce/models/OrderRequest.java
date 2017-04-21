package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private int userId;
    private Customer customer;
    private double total;
    private String note;
    private List<LineItem> lineItems;
}
