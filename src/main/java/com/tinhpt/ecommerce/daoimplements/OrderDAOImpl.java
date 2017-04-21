package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.OrderDAO;
import com.tinhpt.ecommerce.entities.Order;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDAO<Order, Integer> implements OrderDAO {

    @Override
    public List<Order> findByUserId(int userId) {
        String sql = "SELECT * from orders where user_id=:userId";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Order.class);
        return query.list();
    }
}
