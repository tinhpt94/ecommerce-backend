package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.Message;
import com.tinhpt.ecommerce.models.UserModel;
import com.tinhpt.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping( value = "/me", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public UserModel getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        return userService.findByUsername(userName);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ResponseEntity accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to access this page!");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        UserModel existedUser = userService.findByUsername(userModel.getUsername());
        if (existedUser != null) {
            Message message =  new Message("existedUser", "User has existed", "error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } else {
            userService.persist(userModel);
            Message message =  new Message("createUser", "User has been created", "info");
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Message logOut(){
        return new Message("message", "Logout success", "info");
    }
}
