package com.capgemini.lenscart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenscart.exception.NoDuplicateEmailIdException;
import com.capgemini.lenscart.exception.NoDuplicateUserId;
import com.capgemini.lenscart.model.Register;
import com.capgemini.lenscart.service.CustomerNewRegistrationService;

@RestController
@CrossOrigin
@RequestMapping(path = "/customer")
public class CustomerController {
	@Autowired
	CustomerNewRegistrationService customerNewRegistrationService;
	
	/**
	 * Registration for new customer
	 * @param register register object
	 * @return message
	 * @throws NoDuplicateEmailIdException exception for duplicate emailId 
	 * @throws NoDuplicateUserId exception for duplicate userId
	 */

	// http://localhost:8086/lenscart/customer/registration
	@PostMapping(value = "/registration", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> registration(@RequestBody Register register) throws NoDuplicateEmailIdException, NoDuplicateUserId {
		customerNewRegistrationService.registration(register);
		System.out.println("new customer Register in database");
		return ResponseEntity.ok("sucessfull");

	}
	
	/**
	 * login 
	 * @param emailId 
	 * @param password
	 * @return message
	 */
	
	// http://localhost:8086/lenscart/customer/login/pratikshadesai12@gmail.com/pert990
		@RequestMapping(value = "/login/{emailId}/{password}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<String> login(@PathVariable("emailId") String emailId,@PathVariable ("password") String password) {
		boolean flag=customerNewRegistrationService.login(emailId,password);
		if(flag) {
			return ResponseEntity.ok("welcome to E-Commerce");

		}else {
			return ResponseEntity.ok("invalid password or emailId");
			}
		}
}
