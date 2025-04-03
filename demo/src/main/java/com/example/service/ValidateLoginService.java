package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.pojo.UserDetails;

@Service
public class ValidateLoginService {

	@Autowired
	private UserDao userDao;
	
	public Optional<UserDetails> validateLogin(UserDetails user) {
		if(user.getUserid() == null) {
			throw new IllegalArgumentException();
		}
		Optional<UserDetails> findByUserid = userDao.findByUserid(user.getUserid());
		return findByUserid;
		
	}
}