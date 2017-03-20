package com.tinhpt.ecommerce.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {
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

    public Order() {

    }

    public Order(String customerEmail, String customerName, String customerAddress, String customerPhone, String note, double totalCost) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.note = note;
        this.totalCost = totalCost;
        this.createdDate = new Date();
        this.status = "PENDING";
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_email", nullable = true, length = 100)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_name", nullable = false, length = 100)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_address", nullable = false, length = 200)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "customer_phone", nullable = false, length = 20)
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 45)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "total_cost", nullable = false, precision = 0)
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "updated_date", nullable = true)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "updated_by_user", nullable = true, length = 100)
    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (Double.compare(order.totalCost, totalCost) != 0) return false;
        if (customerEmail != null ? !customerEmail.equals(order.customerEmail) : order.customerEmail != null)
            return false;
        if (customerName != null ? !customerName.equals(order.customerName) : order.customerName != null) return false;
        if (customerAddress != null ? !customerAddress.equals(order.customerAddress) : order.customerAddress != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(order.customerPhone) : order.customerPhone != null)
            return false;
        if (note != null ? !note.equals(order.note) : order.note != null) return false;
        if (createdDate != null ? !createdDate.equals(order.createdDate) : order.createdDate != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (updatedDate != null ? !updatedDate.equals(order.updatedDate) : order.updatedDate != null) return false;
        if (updatedByUser != null ? !updatedByUser.equals(order.updatedByUser) : order.updatedByUser != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerAddress != null ? customerAddress.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        temp = Double.doubleToLongBits(totalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (updatedByUser != null ? updatedByUser.hashCode() : 0);
        return result;
    }
}
