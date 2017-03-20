package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.SignUpModel;
import com.tinhpt.ecommerce.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel findByUsername(String username);
    List<UserModel> findAll();

    UserModel persist(SignUpModel signUpModel);
    UserModel findByUserNamePassword(String username, String password);
}
