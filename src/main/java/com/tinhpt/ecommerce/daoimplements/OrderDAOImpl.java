package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.OrderDAO;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDAO<Order, Integer> implements OrderDAO {

}
