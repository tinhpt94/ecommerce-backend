package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.ReportDAO;
import com.tinhpt.ecommerce.entities.Order;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("reportDAO")
public class ReportDAOImpl extends AbstractDAO<Order, Long> implements ReportDAO {
    @Override
    public Object getReport(Date date) {
        String sql = "SELECT COUNT(*) AS orderAmount, SUM(total_cost) AS totalCost from orders WHERE status='DELIVERED' and created_date=:createdDate";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setParameter("createdDate", date);
        return query.uniqueResult();
    }
}
