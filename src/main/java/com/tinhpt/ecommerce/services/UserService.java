package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.UserModel;

import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
public interface UserService {
    UserModel findByUsername(String username);
    List<UserModel> findAll();
    void persist(UserModel userModel);
    UserModel findByUserNamePassword(String username, String password);
}
