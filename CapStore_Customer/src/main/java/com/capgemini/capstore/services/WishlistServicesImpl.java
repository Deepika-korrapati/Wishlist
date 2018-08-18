package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.repo.WishlistCustomerRepo;
import com.capgemini.capstore.repo.WishlistProductRepo;
import com.capgemini.capstore.repo.WishlistRepo;


@Component
public class WishlistServicesImpl implements WishlistServices {
	@Autowired
	private WishlistRepo wRepo;
	
	@Autowired
	private WishlistCustomerRepo cRepo;
	
	@Autowired
	private WishlistProductRepo pRepo;
	@Override
	public Product addProd(Product product) {
		// TODO Auto-generated method stub
		return pRepo.save(product);
		
	}

	@Override
	public Customer addCust(Customer cust) {
		cRepo.save(cust);
		return cust;
	}
	
	
	@Override
	public void add(int custid) {
		Customer customer = cRepo.getOne(custid);
		Wishlist wishlist=new Wishlist();
		wRepo.save(wishlist);
		customer.setWishlist(wRepo.getOne(wishlist.getWishlistId()));
		cRepo.save(customer);
		
	}

	@Override
	public Product addItem(int pid, int custid) {
		Product product=pRepo.getOne(pid);
		Customer customer = cRepo.getOne(custid);
		Wishlist wishlist=wRepo.getOne(customer.getWishlist().getWishlistId());
		List<Product> prod=wishlist.getProduct();
		prod.add(product);
		wishlist.setProduct(prod);
		wRepo.save(wishlist);
		return product;

	}



	@Override
	public void removeItem(int pid, int custid) {
		Product product=pRepo.getOne(pid);
		Customer customer = cRepo.getOne(custid);
		Wishlist wishlist=wRepo.getOne(customer.getWishlist().getWishlistId());
		List<Product> prod=wishlist.getProduct();
		prod.remove(product);
		wishlist.setProduct(prod);
		
		wRepo.save(wishlist);
		
	}

	@Override
	public Wishlist display(int custid) {
		Customer customer = cRepo.getOne(custid);
		return wRepo.getOne(customer.getWishlist().getWishlistId());
	}



	



}
