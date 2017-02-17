package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.models.User;
import com.tinhpt.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping( value = "/me", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        return userService.findByUsername(userName);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied() {
        return "You do not have permission to access this page!";
    }
}
