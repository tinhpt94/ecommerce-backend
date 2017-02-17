package com.tinhpt.ecommerce.daos;

import com.tinhpt.ecommerce.entities.User;

/**
 * Created by PhamTinh on 2/17/2017.
 */
public interface UserDAO {
    User findByUsername(String username);
}
