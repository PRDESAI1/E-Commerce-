package com.capgemini.lenscart.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.lenscart.daoreprository.RegistrationRepository;
import com.capgemini.lenscart.exception.NoDuplicateEmailIdException;
import com.capgemini.lenscart.exception.NoDuplicateUserId;

import com.capgemini.lenscart.model.Register;

@Service
public class CustomerNewRegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;

	// checking no duplicate emailId and register new user
	public void registration(Register register) throws NoDuplicateEmailIdException,NoDuplicateUserId {
		System.out.println("create new registration");
		System.out.println("emailid " + register.getEmailId());
		String reg = register.getEmailId();
		int reg1=register.getUserId();
		Optional<Register> user=registrationRepository.findById(reg1);

		if (register != null) {
			System.out.println("register is not null");
			Register RE = registrationRepository.findByEmailId(reg);

			if (RE != null) {
				System.out.println("re is not null");
				throw new NoDuplicateEmailIdException("Email with " + register.getEmailId() + " already Exist");
			}
			else if(user!=null){
				
				System.out.println("user is not null");
				throw new NoDuplicateUserId("userId"+reg1+"already present");

			}
			else {
				registrationRepository.save(register);
				}
		}

	}
	
	public boolean login(String emailId ,String password) {
		System.out.println("checking emailId and password ");
	
	Register login =registrationRepository.findByEmailId(emailId);
	if(login!=null) {
		if(login.getPassword().equals(password)) {
			System.out.println("welcome");
			return true;
		}
		else {
			System.out.println("wrong");
			return false;
		}
	}
	return false;
	
	

	
	
	}
}






	
	

