package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;

public interface WishlistServices {
	
public Product addProd(Product product);
	
	public Customer addCust(Customer cust);
	
public Product addItem(int pid,int custid);
	
	public void add(int custid);
	
	public void removeItem(int pid,int custid);
	
	public Wishlist display(int custid);
}
