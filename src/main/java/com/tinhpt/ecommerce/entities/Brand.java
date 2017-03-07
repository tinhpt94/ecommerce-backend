package com.tinhpt.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands", schema = "ecommerce")
public class Brand {
    private int id;
    private String code;
    private String brand;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand1 = (Brand) o;

        if (id != brand1.id) return false;
        if (code != null ? !code.equals(brand1.code) : brand1.code != null) return false;
        if (brand != null ? !brand.equals(brand1.brand) : brand1.brand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }
}
