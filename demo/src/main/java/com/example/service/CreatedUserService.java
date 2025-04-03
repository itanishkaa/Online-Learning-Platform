package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.pojo.UserDetails;

@Service
public class CreatedUserService {
    @Autowired
    private UserDao userDao;

    public UserDetails saveUser(UserDetails user) {
        UserDetails details = userDao.save(user);
        return details;
    }
}
