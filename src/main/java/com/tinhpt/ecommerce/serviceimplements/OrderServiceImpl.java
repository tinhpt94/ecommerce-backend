package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.OrderDAO;
import com.tinhpt.ecommerce.daos.OrderDetailDAO;
import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Order;
import com.tinhpt.ecommerce.entities.OrderDetail;
import com.tinhpt.ecommerce.entities.Product;
import com.tinhpt.ecommerce.models.Customer;
import com.tinhpt.ecommerce.models.LineItem;
import com.tinhpt.ecommerce.models.OrderRequest;
import com.tinhpt.ecommerce.models.OrderResponse;
import com.tinhpt.ecommerce.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
            List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderResponse.getId());
            List<LineItem> lineItems = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetails) {
                lineItems.add(modelMapper.map(orderDetail, LineItem.class));
            }
            orderResponse.setLineItems(lineItems);
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    @Override
    public OrderResponse fetchById(int id) {
        Order order = orderDAO.findById(id);
        if (order != null) {
            OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
            List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(orderResponse.getId());
            List<LineItem> lineItems = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetails) {
                lineItems.add(modelMapper.map(orderDetail, LineItem.class));
            }
            orderResponse.setLineItems(lineItems);
            return orderResponse;
        }
        {
            return null;
        }
    }
}
