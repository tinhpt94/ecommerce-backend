package com.tinhpt.ecommerce.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers().disable()
                .anonymous().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/api/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.PUT, "/api/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/api/products/comments").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/api/orders").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/orders").hasAnyRole("MANAGER", "USER")
                .antMatchers(HttpMethod.GET, "/api/orders-user").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/orders/**").hasAnyRole("MANAGER", "USER")
                .antMatchers(HttpMethod.PUT, "/api/orders").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/api/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/api/report").hasRole("MANAGER")
        ;
    }
}

