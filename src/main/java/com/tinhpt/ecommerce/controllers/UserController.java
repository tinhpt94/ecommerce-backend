package com.tinhpt.ecommerce.controllers;

import com.tinhpt.ecommerce.configs.UserDetailService;
import com.tinhpt.ecommerce.models.Credential;
import com.tinhpt.ecommerce.models.Message;
import com.tinhpt.ecommerce.models.SignUpModel;
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

@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "true")
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
    public ResponseEntity createUser(@RequestBody SignUpModel signUpModel) {
        UserModel existedUser = userService.findByUsername(signUpModel.getUsername());
        if (existedUser != null) {
            Message message =  new Message("existedUser", "User has existed", "error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } else {
            UserModel createdUser = userService.persist(signUpModel);
            Message message =  new Message("createUser", "User has been created", "info");
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Credential credential) {
        UserModel result = userService.findByUserNamePassword(credential.getUsername(), credential.getPassword());
        if (result != null) {
            UserDetails userDetails = userDetailService.loadUserByUsername(result.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("message", "Invalid username or password", "error"));
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserModel currentUser = userService.findByUsername(auth.getName());
        if (currentUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(currentUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.DELETE)
    public ResponseEntity logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("message", "Logout successfully!", "info"));
    }
}
