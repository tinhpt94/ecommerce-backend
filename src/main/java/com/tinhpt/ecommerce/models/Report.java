package com.tinhpt.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Report {
    private Date reportDate;
    private int orderAmount;
    private double totalCost;
}
