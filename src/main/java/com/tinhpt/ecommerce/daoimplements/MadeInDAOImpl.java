package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.MadeInDAO;
import com.tinhpt.ecommerce.entities.MadeIn;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("madeInDAO")
public class MadeInDAOImpl extends AbstractDAO<MadeIn, Integer> implements MadeInDAO {
    @Override
    public MadeIn findByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (MadeIn) criteria.uniqueResult();
    }
}
