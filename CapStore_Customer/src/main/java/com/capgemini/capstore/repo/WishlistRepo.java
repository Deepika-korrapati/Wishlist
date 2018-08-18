package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {



}
