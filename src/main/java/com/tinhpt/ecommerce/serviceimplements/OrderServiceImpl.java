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
import com.tinhpt.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public int create(OrderRequest orderRequest) {
        double total = 0;
        for (LineItem item : orderRequest.getLineItems()) {
            total += item.getQuantity() * item.getPrice();
        }
        Customer customer = orderRequest.getCustomer();
        Order order = new Order(customer.getEmail(), customer.getName(), customer.getAddress(), customer.getPhone(), orderRequest.getNote(), total);
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
}
