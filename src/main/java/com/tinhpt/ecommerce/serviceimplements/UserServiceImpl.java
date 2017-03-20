package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.entities.User;
import com.tinhpt.ecommerce.models.SignUpModel;
import com.tinhpt.ecommerce.models.UserModel;
import com.tinhpt.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserModel findByUsername(String userName) {
        User user = userDAO.findByUsername(userName);
        if (user == null) return null;
        else return modelMapper.map(userDAO.findByUsername(userName), UserModel.class);
    }

    @Override
    public List<UserModel> findAll() {
        List<User> userEntities = userDAO.findAll();
        List<UserModel> userModels = new ArrayList<>();
        for (User user: userEntities) {
            UserModel userModelModel = modelMapper.map(user, UserModel.class);
            userModels.add(userModelModel);
        }
        return userModels;
    }

    @Override
    public UserModel persist(SignUpModel signUpModel) {
        User user = new User(
                signUpModel.getUsername(),
                signUpModel.getPassword(),
                signUpModel.getEmail(),
                signUpModel.getName(),
                signUpModel.getAddress(),
                signUpModel.getPhone(),
                new Date(),
                signUpModel.getUsername(),
                null,
                ""
        );
        return modelMapper.map(userDAO.persist(user), UserModel.class);
    }

    @Override
    public UserModel findByUserNamePassword(String username, String password) {
        User user = userDAO.findByUserNamePassword(username, password);
        if (user != null) {
            return modelMapper.map(user, UserModel.class);
        } else return null;
    }
}
