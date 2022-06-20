package com.capgemini.lens.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lens.model.Carts;
import com.capgemini.lens.model.Lens;
import com.capgemini.lens.service.CartService;
import com.capgemini.lens.service.LensService;

@RestController
@CrossOrigin
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	LensService lensService;

	@Autowired
	CartService cartService;

	/**
	 * 
	 * @return list of all lens
	 */

	// http://localhost:8086/lenscart/customer/getLens
	@RequestMapping(path = "/getLens")
	public List<Lens> getLens() {
		List<Lens> lensList = lensService.getLens();
		return lensList;

	}
	
	/**
	 * adding product into cart
	 * @param cart cart object
	 * @return product in cart
	 */

	//http://localhost:8086/lenscart/customer/addCart
	@PostMapping(value = "/addCart", produces = "application/json")
	public ResponseEntity<Carts> addToCart(@RequestBody Carts cart) {
		
		Carts cart1 = cartService.addToCart(cart);
		return ResponseEntity.ok(cart1);

	}
	/**
	 * deleting product from cart
	 * @param id 
	 * @return message
	 */
	// http://localhost:8086/lenscart/customer/deletefromCart/1
	@DeleteMapping(path = "/deletefromCart/{id}", produces = "application/json")
	public String deleteFromCard(@PathVariable("id") int id) {
		
		cartService.deleteFromCart(id);
		System.out.println("delete product from cart");
		return "deleted sucessfully";
		

	}
	/**
	 * updating product in cart
	 * @param carts cart object
	 * @return updated product
	 */
	// http://localhost:8086/lenscart/customer/putCart
	@PutMapping("/putCart")
	public ResponseEntity<Carts> updateInCart(@RequestBody Carts carts) {
		
		System.out.println(carts);
		Carts cart = cartService.updateInCart(carts);
		System.out.println("update product in cart");
		return ResponseEntity.ok(cart);
		
	}
	/**
	 * get all list of product
	 * @return all list of product
	 */
	// http://localhost:8086/lenscart/customer/getCart
	@RequestMapping(path = "/getCart")
	public List<Carts> getFromCart() {
		System.out.println("getting all list of product");
		List<Carts> getFromCart = cartService.getFromCart();
		return getFromCart;
		
	}

}

