package com.tinhpt.ecommerce.models;

import java.sql.Date;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public ProductTypeModel getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeModel productType) {
        this.productType = productType;
    }

    public MadeInModel getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(MadeInModel madeIn) {
        this.madeIn = madeIn;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
