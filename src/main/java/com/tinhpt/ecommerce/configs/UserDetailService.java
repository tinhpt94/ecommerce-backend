package com.tinhpt.ecommerce.configs;

import com.tinhpt.ecommerce.daos.UserDAO;
import com.tinhpt.ecommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDAO.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("UserModel " + username + " not found");
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
            grantedAuthorities.add(grantedAuthority);

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), true, true, true, true,
                    grantedAuthorities
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException("UserModel " + username + " not found");
        }
    }
}
