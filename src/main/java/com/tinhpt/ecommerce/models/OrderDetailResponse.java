package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class OrderDetailResponse {
    private int id;
    private String customerEmail;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String note;
    private Date createdDate;
    private double totalCost;
    private String status;
    private Date updatedDate;
    private String updatedByUser;
    private List<LineItem> lineItems;
}
