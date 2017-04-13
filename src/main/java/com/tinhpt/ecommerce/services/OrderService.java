package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.OrderDetailResponse;
import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderResponse;
import com.tinhpt.ecommerce.models.OrderUpdate;

import java.util.List;

public interface OrderService {
    int create(OrderRequest order);

    OrderDetailResponse updateOrder(OrderUpdate orderUpdate);
    List<OrderResponse> fetchAll();

    OrderDetailResponse fetchById(int id);
}
