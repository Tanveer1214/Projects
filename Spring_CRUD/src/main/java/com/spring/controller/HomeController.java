package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.model.Product;
import com.spring.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String Home(Model model) {
		List<Product> list = this.productService.getMultiProducts();
		model.addAttribute("list",list);
		return "home";
	}

	// add product controller
	@RequestMapping("/add-product")
	public String Add_Product(Model model) {
		model.addAttribute("title","Add Product");
		return "add-product-form";
	}
	
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProudct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		this.productService.changeProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	//delete product
	@RequestMapping("/delete/{id}")
	public RedirectView Delete_Product(@PathVariable("id") int id, HttpServletRequest request) {
		this.productService.delProduct(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	//update product
	@RequestMapping("/update/{id}")
	public String Update_Product(@PathVariable("id") int id, Model model) {
		Product product = this.productService.getOneProduct(id);
		model.addAttribute("product", product);
		return "update-form";
	}
	
	// Getter and Setter
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
