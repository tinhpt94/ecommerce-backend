package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.OrderDetailDAO;
import com.tinhpt.ecommerce.entities.OrderDetail;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDetailDAO")
public class OrderDetailDAOImpl extends AbstractDAO<OrderDetail, Integer> implements OrderDetailDAO {
    @Override
    public List<OrderDetail> findByOrderId(Integer id) {
        String sql = "SELECT * from order_details where orders_id=:orders_id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addEntity(OrderDetail.class);
        query.setParameter("orders_id", id);
        return query.list();
    }
}
