package com.capgemini.ecommarce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ecommarce.entity.Carts;
import com.capgemini.ecommarce.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;

	// add product into cart
	public Carts addToCart(Carts cart) {
		return cartRepository.save(cart);
	}

	// delete product from cart
	public List<Carts> deleteFromCart(int id) {
		cartRepository.deleteById(id);
		return cartRepository.findAll();
	}

	// update into cart
	public Carts updateInCart(Carts carts) {
		return cartRepository.saveAndFlush(carts);
	}

	// get list of all product in cart
	public List<Carts> getFromCart() {
		return cartRepository.findAll();
	}

}
