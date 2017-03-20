package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDAO")
public class ProductDAOImpl extends AbstractDAO<Product, Integer> implements ProductDAO {

    @Override
    public Product findByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public List<Product> findByBrandCode(String code) {
        String strSQL = "SELECT * from products, brands WHERE products.brand = brands.id AND brands.code = :code";
        SQLQuery query = getSession().createSQLQuery(strSQL);
        query.addEntity(Product.class);
        query.setParameter("code", code);
        return query.list();
    }

    @Override
    public List<Product> findByProductTypeCode(String code) {
        String strSQL = "SELECT * from products, product_types WHERE products.product_type = product_types.id AND product_types.code = :code";
        SQLQuery query = getSession().createSQLQuery(strSQL);
        query.addEntity(Product.class);
        query.setParameter("code", code);
        return query.list();
    }

    @Override
    public List<Product> findByMadeInCode(String code) {
        String strSQL = "SELECT * from products, made_ins WHERE products.made_in = made_ins.id AND made_ins.code = :code";
        SQLQuery query = getSession().createSQLQuery(strSQL);
        query.addEntity(Product.class);
        query.setParameter("code", code);
        return query.list();
    }
}
