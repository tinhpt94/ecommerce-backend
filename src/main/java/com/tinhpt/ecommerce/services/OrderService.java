package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderResponse;

import java.util.List;

public interface OrderService {
    int create(OrderRequest order);

    List<OrderResponse> fetchAll();

    OrderResponse fetchById(int id);
}
