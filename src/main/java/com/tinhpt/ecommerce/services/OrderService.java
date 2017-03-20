package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.OrderRequest;

public interface OrderService {
    int create(OrderRequest order);
}
