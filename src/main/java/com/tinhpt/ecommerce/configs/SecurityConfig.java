package com.tinhpt.ecommerce.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
                .csrf().disable();
//                .formLogin()
//                    .loginProcessingUrl("/api/login")
//                    .defaultSuccessUrl("/api/me")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .and()
//                .exceptionHandling()
//                    .accessDeniedPage("/api/403")
//                .and()
//                .logout()
//                    .logoutUrl("/api/logout")
//                    .logoutSuccessUrl("/api/hello")
//                    .deleteCookies("JSESSIONID")
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
//                //.antMatchers(HttpMethod.GET, "/api/authenticate").authenticated()
//                .antMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/products").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/products").hasRole("ADMIN");
    }
}

