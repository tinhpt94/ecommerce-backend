package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.entities.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO<User, Long> implements UserDAO {

    @Override
    public User findByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
}
