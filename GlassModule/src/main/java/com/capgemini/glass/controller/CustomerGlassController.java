package com.capgemini.glass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.glass.model.Cart;
import com.capgemini.glass.model.Glass;
import com.capgemini.glass.service.CartService;
import com.capgemini.glass.service.GlassService;

@RestController
@CrossOrigin
@RequestMapping(path="/customer")
public class CustomerGlassController {

	@Autowired
	GlassService glassService;
	
	@Autowired
	CartService cartService;
	
		// http://localhost:8086/lenscart/customer/getGlass
		@RequestMapping(path = "/getGlass")
		public List<Glass> getGlass() {
		List<Glass> glassList = glassService.getGlass();
		return glassList;
		}
		
		//http://localhost:8086/lenscart/customer/getCart
	    @RequestMapping(path="/getCart")
	    public List<Cart> getFromCart(){
		System.out.println("getting all list of product");
		List<Cart> getFromCart = cartService.getFromCart();
		return getFromCart;	
	    }

	    //http://localhost:8086/lenscart/customer/addCart
		@PostMapping(value = "/addCart", produces = "application/json")
		public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
		Cart cart1 = cartService.addToCart(cart);
		return ResponseEntity.ok(cart1);
		}
		
		// http://localhost:8086/lenscart/customer/deletefromCart/1
		@DeleteMapping(path = "/deletefromCart/{id}", produces = "application/json")
		public String deleteFromCard(@PathVariable("id") int id) {
		cartService.deleteFromCart(id);
		System.out.println("delete product from cart");
		return "deleted sucessfully";
		}
		
		// http://localhost:8086/lenscart/customer/putCart
		@PutMapping("/putCart")
		public ResponseEntity<Cart> updateInCart(@RequestBody Cart cart) {
		System.out.println(cart);
		Cart carts = cartService.updateInCart(cart);
		System.out.println("update product in cart");
		return ResponseEntity.ok(cart);	
		}
}
