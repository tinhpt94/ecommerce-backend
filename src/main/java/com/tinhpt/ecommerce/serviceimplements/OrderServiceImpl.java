package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.OrderDAO;
import com.tinhpt.ecommerce.daos.OrderDetailDAO;
import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Order;
import com.tinhpt.ecommerce.entities.OrderDetail;
import com.tinhpt.ecommerce.entities.Product;
import com.tinhpt.ecommerce.models.*;
import com.tinhpt.ecommerce.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int create(OrderRequest orderRequest) {
        Customer customer = orderRequest.getCustomer();
        Order order = new Order(customer.getEmail(), customer.getName(), customer.getAddress(), customer.getPhone(), orderRequest.getNote(), orderRequest.getTotal());
        int orderID = orderDAO.save(order);

        for (LineItem item : orderRequest.getLineItems()) {
            OrderDetail orderDetail = new OrderDetail(item.getName(), item.getPrice(), item.getQuantity(), item.getCode(), item.getImageUrl(), orderID);
            orderDetailDAO.save(orderDetail);
            Product product = productDAO.findByCode(item.getCode());
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productDAO.update(product);
        }
        return orderID;
    }

    @Override
    public List<OrderResponse> fetchAll() {
        List<Order> orders = orderDAO.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            orderResponses.add(mapEntity2Modal(order));
        }
        return orderResponses;
    }

    @Override
    public OrderResponse fetchById(int id) {
        Order order = orderDAO.findById(id);
        if (order != null) {
            return mapEntity2Modal(order);
        }
        {
            return null;
        }
    }

    @Override
    public OrderResponse updateOrder(OrderUpdate orderUpdate) {
        Order order = orderDAO.findById(orderUpdate.getId());
        order.setStatus(orderUpdate.getStatus());
        order.setUpdatedDate(new Date());
        order.setUpdatedByUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return mapEntity2Modal(orderDAO.merge(order));
    }

    private OrderResponse mapEntity2Modal(Order order) {
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderResponse.getId());
        List<LineItem> lineItems = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            lineItems.add(modelMapper.map(orderDetail, LineItem.class));
        }
        orderResponse.setLineItems(lineItems);
        return orderResponse;
    }
}
