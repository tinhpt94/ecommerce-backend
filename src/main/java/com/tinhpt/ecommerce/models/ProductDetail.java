package com.tinhpt.ecommerce.models;

import java.sql.Date;

public class ProductDetail {
    private int id;
    private String name;
    private String code;
    private double price;
    private String brand;
    private String madeIn;
    private String collection;
    private String model;
    private String gender;
    private Double diameter;
    private Double thickness;
    private Double weight;
    private String waterProof;
    private Byte alarm;
    private Integer warrantyTime;
    private String imageUrl;
    private Date createdDate;
    private Date updatedDate;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWaterProof() {
        return waterProof;
    }

    public void setWaterProof(String waterProof) {
        this.waterProof = waterProof;
    }

    public Byte getAlarm() {
        return alarm;
    }

    public void setAlarm(Byte alarm) {
        this.alarm = alarm;
    }

    public Integer getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(Integer warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
