package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ProductDao;
import com.spring.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void createProduct(Product product) {
		this.productDao.addProduct(product);
	}
	
	public void delProduct(int id) {
		this.productDao.deleteProduct(id);
	}
	
	public void changeProduct(Product product) {
		this.productDao.updateProduct(product);
	}
	
	public Product getOneProduct(int id) {
		return this.productDao.getSingleProduct(id);
	}
	
	public List<Product> getMultiProducts() {
		return this.productDao.getAllProducts();
//		for(Product i : list) {
//			System.out.println("__________________________");
//			System.out.println("Id: "+i.getId());
//			System.out.println("Name: "+i.getName());
//			System.out.println("Discription: "+i.getDiscription());
//			System.out.println("Price "+i.getPrice());
//		}
	}
	
	
	// Getter and Setter
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
