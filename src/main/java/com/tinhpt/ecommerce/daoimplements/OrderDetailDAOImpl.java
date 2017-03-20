package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.OrderDetailDAO;
import org.springframework.stereotype.Repository;

@Repository("orderDetailDAO")
public class OrderDetailDAOImpl extends AbstractDAO<OrderDetail, Integer> implements OrderDetailDAO {
}
