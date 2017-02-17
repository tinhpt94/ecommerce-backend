package com.tinhpt.ecommerce.configs;

import com.tinhpt.ecommerce.models.User;
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
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User " + username + " not found");
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
            grantedAuthorities.add(grantedAuthority);

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), grantedAuthorities
            );

            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }
}
