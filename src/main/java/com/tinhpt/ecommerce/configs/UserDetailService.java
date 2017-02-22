package com.tinhpt.ecommerce.configs;

import com.tinhpt.ecommerce.models.UserModel;
import com.tinhpt.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhamTinh on 2/17/2017.
 */
@Service("userDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel userModel = userService.findByUsername(username);
            if (userModel == null) {
                throw new UsernameNotFoundException("UserModel " + username + " not found");
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + userModel.getRole());
            grantedAuthorities.add(grantedAuthority);

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    userModel.getUsername(), userModel.getPassword(), true, true, true, true,
                    grantedAuthorities
            );

            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException("UserModel " + username + " not found");
        }
    }
}
