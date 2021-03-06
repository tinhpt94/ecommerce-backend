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
        Order order =
                new Order(
                        customer.getEmail(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getPhone(),
                        orderRequest.getNote(),
                        orderRequest.getTotal(),
                        orderRequest.getUserId()
                );
        int orderID = orderDAO.save(order);

        for (LineItem item : orderRequest.getLineItems()) {
            OrderDetail orderDetail = new OrderDetail(item.getName(), item.getPrice(), item.getAmount(), item.getCode(), item.getImageUrl(), orderID, item.getDiscount());
            orderDetailDAO.save(orderDetail);
            Product product = productDAO.findByCode(item.getCode());
            product.setQuantity(product.getQuantity() - item.getAmount());
            productDAO.update(product);
        }
        return orderID;
    }

    @Override
    public List<OrderResponse> fetchAll() {
        List<Order> orders = orderDAO.findAll();
        List<OrderResponse> orderDetailResponses = new ArrayList<>();
        for (Order order : orders) {
            orderDetailResponses.add(modelMapper.map(order, OrderResponse.class));
        }
        return orderDetailResponses;
    }

    @Override
    public OrderDetailResponse fetchById(int id) {
        Order order = orderDAO.findById(id);
        if (order != null) {
            return mapEntity2Modal(order);
        } else {
            return null;
        }
    }

    @Override
    public OrderDetailResponse updateOrder(OrderUpdate orderUpdate) {
        Order order = orderDAO.findById(orderUpdate.getId());
        order.setStatus(orderUpdate.getStatus());
        order.setUpdatedDate(new Date());
        order.setUpdatedByUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return mapEntity2Modal(orderDAO.merge(order));
    }

    @Override
    public List<OrderResponse> fetchByUserId(int userId) {
        List<Order> orders = orderDAO.findByUserId(userId);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            orderResponses.add(modelMapper.map(order, OrderResponse.class));
        }
        return orderResponses;
    }

    @Override
    public List<OrderResponse> fetchByDate(Date fromDate, Date toDate) {
        List<Order> orders = orderDAO.findByDate(fromDate, toDate);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            orderResponses.add(modelMapper.map(order, OrderResponse.class));
        }
        return orderResponses;
    }

    private OrderDetailResponse mapEntity2Modal(Order order) {
        OrderDetailResponse orderDetailResponse = modelMapper.map(order, OrderDetailResponse.class);
        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderDetailResponse.getId());
        List<LineItem> lineItems = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            lineItems.add(modelMapper.map(orderDetail, LineItem.class));
        }
        orderDetailResponse.setLineItems(lineItems);
        return orderDetailResponse;
    }
}
