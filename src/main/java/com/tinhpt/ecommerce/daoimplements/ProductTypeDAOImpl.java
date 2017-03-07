package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.ProductTypeDAO;
import com.tinhpt.ecommerce.entities.ProductType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("productTypeDAO")
public class ProductTypeDAOImpl extends AbstractDAO<ProductType, Integer> implements ProductTypeDAO {
    @Override
    public ProductType findByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (ProductType) criteria.uniqueResult();
    }
}
