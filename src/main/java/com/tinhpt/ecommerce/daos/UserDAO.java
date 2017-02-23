package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.User;

import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
public interface UserDAO {
    List<User> findAll();
    User findByUsername(String username);
    void persist(User user);
    User findByUserNamePassword(String userName, String password);
}
