package com.capgemini.glass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.glass.model.Glass;
import com.capgemini.glass.service.GlassService;

@RestController
@CrossOrigin
@RequestMapping(path="/product")        //mapping web requests onto methods in request-handling classes
public class AdminGlassController {

	@Autowired                //Marks a constructor, field, setter method, or config method as to be autowired bySpring's dependency injection facilities
	GlassService glassService;

	//http://localhost:8086/lenscart/product/getGlass
	@RequestMapping(path="/getGlass")
	public List<Glass> getGlass(){
	List<Glass> glassList= glassService.getGlass();
	return glassList;
	}
	
	//http://localhost:8086/lenscart/product/addGlass
	@PostMapping(value = "/addGlass", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Glass> addGlass(@RequestBody Glass glass) { 
	glassService.addGlass(glass);
	System.out.println("add glass in database");
	return ResponseEntity.ok(glass);           //ResponseEntity -> adds http status code ok
	}
	
	//http://localhost:8086/lenscart/product/putGlass
	@PutMapping("/putGlass")
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass){
	System.out.println(glass);
	Glass glass1= glassService.updateGlass(glass);
	System.out.println("update Glass in database");
	return new ResponseEntity<Glass>(glass1, HttpStatus.OK);
	}
	
	//http://localhost:8086/lenscart/product/deleteGlass/103
	@DeleteMapping(path = "/deleteGlass/{glassId}", produces = "application/json")
	public ResponseEntity<List<Glass>> deleteGlass(@PathVariable("glassId") int glassId) {
	List<Glass> glass= glassService.deleteGlass(glassId);
	System.out.println("delete Glass in database");
	return new ResponseEntity<List<Glass>>(glass, HttpStatus.OK);
	}
}
