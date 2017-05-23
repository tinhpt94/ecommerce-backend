package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.OrderDetailResponse;
import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderResponse;
import com.tinhpt.ecommerce.models.OrderUpdate;

import java.util.Date;
import java.util.List;

public interface OrderService {
    int create(OrderRequest order);

    OrderDetailResponse updateOrder(OrderUpdate orderUpdate);
    List<OrderResponse> fetchAll();

    List<OrderResponse> fetchByDate(Date fromDate, Date toDate);
    List<OrderResponse> fetchByUserId(int userId);
    OrderDetailResponse fetchById(int id);
}
