package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.configs.UserDetailService;
import com.tinhpt.ecommerce.models.Message;
import com.tinhpt.ecommerce.models.UserModel;
import com.tinhpt.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    UserDetailService userDetailService;

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

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserModel userModel) {
        UserModel result = userService.findByUserNamePassword(userModel.getUsername(), userModel.getPassword());
        if (result != null) {
            UserDetails userDetails = userDetailService.loadUserByUsername(result.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("message", "Invalid username or password", "error"));
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.DELETE)
    public ResponseEntity logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("message", "Logout successfully!", "info"));
    }
}
