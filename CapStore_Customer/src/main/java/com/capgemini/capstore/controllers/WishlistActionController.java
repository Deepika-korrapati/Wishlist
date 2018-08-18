package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.services.WishlistServices;

@RestController
public class WishlistActionController {
	@Autowired
	WishlistServices service;
	
	@RequestMapping(value="/addProd")
	public Product addProd(@RequestBody Product product)
	{
		return service.addProd(product);
	}
	
	@RequestMapping(value="/addCust")
	public Customer addCust(Customer customer)
	{
		return service.addCust(customer);
	}
	

	@RequestMapping(value="/addItem")
	public Product addProduct(int pid,int cid)
	{
		return service.addItem(pid,cid);
	}
	@RequestMapping(value="/removeItem")
	public void delProduct(int pid,int cid)
	{
		 service.removeItem(pid,cid);
	}
	@RequestMapping(value="/add")
	public void add(int cid)
	{
		service.add(cid);
	}
	@RequestMapping(value="/display")
	public Wishlist display(int cid)
	{
		return service.display(cid);
	}




}
