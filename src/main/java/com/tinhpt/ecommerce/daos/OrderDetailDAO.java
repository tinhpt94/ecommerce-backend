package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.OrderDetail;

import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetail> findAll();
    OrderDetail findById(Integer id);
    Integer save(OrderDetail orderDetail);

    List<OrderDetail> findByOrderId(Integer id);
}
