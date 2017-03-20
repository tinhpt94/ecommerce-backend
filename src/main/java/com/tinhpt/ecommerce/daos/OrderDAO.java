package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll();

    Order findById(Integer id);

    Integer save(Order order);
}
