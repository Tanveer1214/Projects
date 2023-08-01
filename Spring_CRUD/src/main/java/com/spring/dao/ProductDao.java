package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.model.Product;

import jakarta.transaction.Transactional;

@Component
public class ProductDao {

	@Autowired
	@Qualifier("local")
	private SessionFactory sessionFactory;

	@Transactional
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().persist(product);
		System.out.println("Product added");
	}
	
	@Transactional
	public List<Product> getAllProducts() {
		Session session =  this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product",Product.class).getResultList();
	}
	
	@Transactional
	public Product getSingleProduct(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}
	
	@Transactional
	public void deleteProduct(int id) {
		Product p = this.sessionFactory.getCurrentSession().get(Product.class, id);
		this.sessionFactory.getCurrentSession().remove(p);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(product);
	}
	
	// Getter and Setter
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
