package com.maytic.SpringPortfolioApp.service;

import com.maytic.SpringPortfolioApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * user login service
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.getUserByName(s);

        if(user == null){
            throw new UsernameNotFoundException("Could not find user: " + s);
        }

        return user;

    }
}
