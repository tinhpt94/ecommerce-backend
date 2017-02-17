package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.models.User;
import com.tinhpt.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public User findByUsername(String userName) {
        return modelMapper.map(userDAO.findByUsername(userName), User.class);
    }
}
