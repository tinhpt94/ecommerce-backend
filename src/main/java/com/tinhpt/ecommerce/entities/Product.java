package com.tinhpt.ecommerce.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "products", schema = "ecommerce")
public class Product {
    private int id;
    private String name;
    private String code;
    private double price;
    private String description;
    private String imageUrl;
    private int quantity;
    private Date createdDate;
    private Date updatedDate;
    private int productType;
    private int brand;
    private int madeIn;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    @Column(name = "product_type")
    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "brand")
    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "made_in")
    public int getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(int madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (productType != product.productType) return false;
        if (brand != product.brand) return false;
        if (madeIn != product.madeIn) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (code != null ? !code.equals(product.code) : product.code != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
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
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + productType;
        result = 31 * result + brand;
        result = 31 * result + madeIn;
        return result;
    }
}
