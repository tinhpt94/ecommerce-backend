package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderResponse;
import com.tinhpt.ecommerce.models.OrderUpdate;

import java.util.List;

public interface OrderService {
    int create(OrderRequest order);

    OrderResponse updateOrder(OrderUpdate orderUpdate);
    List<OrderResponse> fetchAll();

    OrderResponse fetchById(int id);
}
