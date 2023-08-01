package com.spring.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entities.User;

import jakarta.transaction.Transactional;

@Repository
public class UserDao {
	
	@Autowired
	@Qualifier("local")
	private SessionFactory sessionFactory;
	
	@Transactional
	public void Insert(User user) {
		this.sessionFactory.getCurrentSession().persist(user);
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
