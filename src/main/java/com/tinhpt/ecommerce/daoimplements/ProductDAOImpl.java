package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.ProductDAO;
import com.tinhpt.ecommerce.entities.Product;
import org.hibernate.Criteria;
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
        Criteria criteria = getSession().createCriteria(Product.class, "product");
        criteria
                .createAlias("product.brands", "brand")
                .add(Restrictions.eq("brand.code", code));
        return criteria.list();
    }

    @Override
    public List<Product> findByProductTypeCode(String code) {
        Criteria criteria = getSession().createCriteria(Product.class, "product");
        criteria
                .createAlias("product.made_ins", "made_in")
                .add(Restrictions.eq("made_in.code", code));
        return criteria.list();
    }

    @Override
    public List<Product> findByMadeInCode(String code) {
        Criteria criteria = getSession().createCriteria(Product.class, "product");
        criteria
                .createAlias("product.product_types", "product_type")
                .add(Restrictions.eq("product_type.code", code));
        return criteria.list();
    }
}
