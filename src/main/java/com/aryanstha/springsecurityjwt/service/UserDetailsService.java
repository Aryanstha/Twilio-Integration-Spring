package com.aryanstha.springsecurityjwt.service;

import com.aryanstha.springsecurityjwt.repository.UserRepository;
import com.aryanstha.springsecurityjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
        User user = repository.findByUserName(phoneNo);
        if(user==null){
            user = new User();
            user.setUserName(phoneNo);
            repository.save(user);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), "",
                new ArrayList<>());
    }
}