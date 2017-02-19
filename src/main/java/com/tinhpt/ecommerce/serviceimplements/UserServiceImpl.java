package com.tinhpt.ecommerce.serviceimplements;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.entities.User;
import com.tinhpt.ecommerce.models.UserModel;
import com.tinhpt.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
    public void persist(UserModel userModel) {
        User user = new User(
                userModel.getEmail(),
                userModel.getName(),
                userModel.getPhone(),
                userModel.getAddress(),
                userModel.getUsername()
        );
        user.setPassword(encoder.encode(userModel.getPassword()));
        userDAO.persist(user);
    }
}
