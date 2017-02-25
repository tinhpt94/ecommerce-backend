package com.tinhpt.ecommerce.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tinhpt on 2/25/17.
 */
@Entity
@Table(name = "products", schema = "ecommerce", catalog = "")
public class Product {
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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "made_in")
    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Basic
    @Column(name = "collection")
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "diameter")
    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "thickness")
    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    @Basic
    @Column(name = "weight")
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "water_proof")
    public String getWaterProof() {
        return waterProof;
    }

    public void setWaterProof(String waterProof) {
        this.waterProof = waterProof;
    }

    @Basic
    @Column(name = "alarm")
    public Byte getAlarm() {
        return alarm;
    }

    public void setAlarm(Byte alarm) {
        this.alarm = alarm;
    }

    @Basic
    @Column(name = "warranty_time")
    public Integer getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(Integer warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "updated_date")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (code != null ? !code.equals(product.code) : product.code != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (madeIn != null ? !madeIn.equals(product.madeIn) : product.madeIn != null) return false;
        if (collection != null ? !collection.equals(product.collection) : product.collection != null) return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (gender != null ? !gender.equals(product.gender) : product.gender != null) return false;
        if (diameter != null ? !diameter.equals(product.diameter) : product.diameter != null) return false;
        if (thickness != null ? !thickness.equals(product.thickness) : product.thickness != null) return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        if (waterProof != null ? !waterProof.equals(product.waterProof) : product.waterProof != null) return false;
        if (alarm != null ? !alarm.equals(product.alarm) : product.alarm != null) return false;
        if (warrantyTime != null ? !warrantyTime.equals(product.warrantyTime) : product.warrantyTime != null)
            return false;
        if (imageUrl != null ? !imageUrl.equals(product.imageUrl) : product.imageUrl != null) return false;
        if (createdDate != null ? !createdDate.equals(product.createdDate) : product.createdDate != null) return false;
        if (updatedDate != null ? !updatedDate.equals(product.updatedDate) : product.updatedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (madeIn != null ? madeIn.hashCode() : 0);
        result = 31 * result + (collection != null ? collection.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (thickness != null ? thickness.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (waterProof != null ? waterProof.hashCode() : 0);
        result = 31 * result + (alarm != null ? alarm.hashCode() : 0);
        result = 31 * result + (warrantyTime != null ? warrantyTime.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
