package com.tinhpt.ecommerce.daoimplements;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.entities.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {

    @Override
    public User findByUserNamePassword(String userName, String password) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", userName));
        criteria.add(Restrictions.eq("password", password));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
}
