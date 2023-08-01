package com.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void createUser(User user) {
		this.userDao.Insert(user);
	}
 
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
