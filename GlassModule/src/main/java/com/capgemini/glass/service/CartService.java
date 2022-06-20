package com.capgemini.glass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.glass.daoRepository.CartRepository;
import com.capgemini.glass.model.Cart;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	// add product into cart
	public Cart addToCart(Cart cart) {
	return cartRepository.save(cart);

	}

	// delete product from cart
	public List<Cart> deleteFromCart(int id) {
	cartRepository.deleteById(id);
	return cartRepository.findAll();
	}

	// update into cart
	public Cart updateInCart(Cart cart) {
	return cartRepository.saveAndFlush(cart);
	}

	// get list of all product in cart
	public List<Cart> getFromCart() {
	return cartRepository.findAll();
	}

}
