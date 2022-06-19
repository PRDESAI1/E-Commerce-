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
@RequestMapping(path="/product")//mapping web requests onto methods in request-handling classes
public class AdminController {
	@Autowired
	CustomerNewRegistrationService customerNewRegistrationService;
	


	
	
	

	/**
	 * adminLogin method is use to check admin emailId and password
	 * @param emailId 
	 * @param password
	 * @return  message
	 */
	
	//http://localhost:8086/lenscart/product/adminLogin/prasaddeshmukh23@gmail.com/rsedf3890
	@RequestMapping(value = "/adminLogin/{emailId}/{password}")
	public ResponseEntity<String> login(@PathVariable("emailId") String emailId,@PathVariable ("password") String password) {
		 String adminEmailId ="prasaddeshmukh23@gmail.com";
		 String adminPassword="rsedf3890";
		 System.out.println(adminEmailId + " "+adminPassword);
		 System.out.println(emailId+" "+password);
		 if(adminEmailId.equals(emailId) && adminPassword.equals(password)) {
			 return ResponseEntity.ok("welcome admin");
		 }else {
			 return ResponseEntity.ok("invalid admin credential");
		 }
}
}