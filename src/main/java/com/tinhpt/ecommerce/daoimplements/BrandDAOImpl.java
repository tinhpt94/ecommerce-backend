package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.BrandDAO;
import com.tinhpt.ecommerce.entities.Brand;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("brandDAO")
public class BrandDAOImpl extends AbstractDAO<Brand, Integer> implements BrandDAO {
    @Override
    public Brand findByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (Brand) criteria.uniqueResult();
    }
}
