package com.tinhpt.ecommerce.services;

import com.tinhpt.ecommerce.models.User;

/**
 * Created by PhamTinh on 2/17/2017.
 */
public interface UserService {
    User findByUsername(String username);
}
