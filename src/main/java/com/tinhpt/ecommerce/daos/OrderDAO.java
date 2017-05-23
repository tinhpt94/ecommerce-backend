package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderDAO {
    List<Order> findAll();

    List<Order> findByDate(Date fromDate, Date toDate);
    void update(Order order);
    Order findById(Integer id);

    List<Order> findByUserId(int userId);
    Order merge(Order order);
    Integer save(Order order);
}
