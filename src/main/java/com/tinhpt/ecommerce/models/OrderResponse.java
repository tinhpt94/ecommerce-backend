package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderResponse {
    private int id;
    private String customerName;
    private Date createdDate;
    private double totalCost;
    private String status;
}
