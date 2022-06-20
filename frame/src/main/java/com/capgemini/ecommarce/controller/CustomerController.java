package com.capgemini.ecommarce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ecommarce.entity.Carts;
import com.capgemini.ecommarce.entity.Frame;
import com.capgemini.ecommarce.service.CartService;
import com.capgemini.ecommarce.service.FrameService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
	@Autowired
	FrameService frameService;
	
	@Autowired
	CartService cartService;

	
	/**
	 * 
	 * @return list of all frames 
	 */

	// http://localhost:8086/lenscart/customer/getFrame
	@RequestMapping(path = "/getFrame")
	public List<Frame> getFrame() {
		List<Frame> frameList = frameService.getFrame();
		return frameList;

	}
	
	//add to the cart method
	// http://localhost:8086/lenscart/customer/addCart
	@PostMapping(value = "/addCart", produces = "application/json")
	public ResponseEntity<Carts> addToCart(@RequestBody Carts cart) {
		
		Carts cart1 = cartService.addToCart(cart);
		return ResponseEntity.ok(cart1);

	}
	
	//Delete from the cart method
	// http://localhost:8086/lenscart/customer/deletefromCart/1
	@DeleteMapping(path = "/deletefromCart/{id}", produces = "application/json")
	public String deleteFromCard(@PathVariable("id") int id) {
		
		cartService.deleteFromCart(id);
		System.out.println("delete product from cart");
		return "deleted sucessfully";
		

	}
	
	//put in the cart
	// http://localhost:8086/lenscart/customer/putCart
	@PutMapping("/putCart")
	public ResponseEntity<Carts> updateInCart(@RequestBody Carts carts) {
		
		System.out.println(carts);
		Carts cart = cartService.updateInCart(carts);
		System.out.println("update product in cart");
		return ResponseEntity.ok(cart);
		
	}
	
	
}
