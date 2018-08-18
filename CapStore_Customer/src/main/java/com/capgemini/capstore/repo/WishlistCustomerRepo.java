package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Customer;

public interface WishlistCustomerRepo extends JpaRepository<Customer, Integer> {

}
