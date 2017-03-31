package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll();

    void update(Order order);
    Order findById(Integer id);

    Order merge(Order order);
    Integer save(Order order);
}
