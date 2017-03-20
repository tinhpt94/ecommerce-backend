package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findByUsername(String username);

    User persist(User user);
    User findByUserNamePassword(String userName, String password);
}
