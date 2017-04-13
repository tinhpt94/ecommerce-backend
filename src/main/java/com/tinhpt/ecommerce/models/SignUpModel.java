package com.tinhpt.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpModel {
    private String email;
    private String name;
    private String phone;
    private String address;
    private String username;
    private String password;
}
