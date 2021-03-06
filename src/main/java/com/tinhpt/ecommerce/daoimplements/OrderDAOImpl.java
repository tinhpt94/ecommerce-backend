package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.OrderDAO;
import com.tinhpt.ecommerce.entities.Order;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDAO<Order, Integer> implements OrderDAO {

    @Override
    public List<Order> findByUserId(int userId) {
        String sql = "SELECT * from orders where user_id=:userId order by created_date desc";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setParameter("userId", userId);
        query.addEntity(Order.class);
        return query.list();
    }

    public List<Order> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate"));
        return criteria.list();
    }

    @Override
    public List<Order> findByDate(Date fromDate, Date toDate) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.ge("createdDate", fromDate));
        criteria.add(Restrictions.le("createdDate", toDate));
        criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate"));
        return criteria.list();
    }
}
