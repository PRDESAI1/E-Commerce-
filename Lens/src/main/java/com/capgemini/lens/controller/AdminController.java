package com.capgemini.lens.controller;

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

import com.capgemini.lens.model.Lens;
import com.capgemini.lens.service.LensService;


@RestController
@CrossOrigin
@RequestMapping(path="/product")//mapping web requests onto methods in request-handling classes
public class AdminController {

  
	@Autowired
	LensService adminLensService;
	
	
		
		

		/**
	 * 
	 * @return list of all Lens
	 */
	//http://localhost:8086/lenscart/product/getLens
	@RequestMapping(path="/getLens")
	public List<Lens> getLens(){
		List<Lens> lensList=adminLensService.getLens();
		return lensList;
		}
	/**
	 * adding new lens
	 * @param lens object 
	 * @return newly added glass
	 */
	
	//http://localhost:8086/lenscart/product/addLens
	@PostMapping(value = "/addLens", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Lens> addLens(@RequestBody Lens lens) { 
		adminLensService.addLens(lens);
		System.out.println("add Lens in database");
		return ResponseEntity.ok(lens);
		
		
	}
	/**
	 * updating lens
	 * @param lens lens object
	 * @return updated version of lens
	 */
	
	//http://localhost:8086/lenscart/product/putLens
	@PutMapping("/putLens")
	public ResponseEntity<Lens> updateLens(@RequestBody Lens lens){
		System.out.println(lens);
		Lens lens1= adminLensService.updateLens(lens);
		System.out.println("update Lens in database");
		return new ResponseEntity<Lens>(lens1, HttpStatus.OK);
		
	}
	/**
	 * deleting lens by lensId
	 * @param lensId
	 * @return list of remaining lens
	 */
	
	//http://localhost:8086/lenscart/product/deleteLens/4
	@DeleteMapping(path = "/deleteLens/{lensId}", produces = "application/json")
	public ResponseEntity<List<Lens>> deleteLens(@PathVariable("lensId") int lensId) {
		List<Lens> lens= adminLensService.deleteLens(lensId);
		System.out.println("delete Lens in database");
		return new ResponseEntity<List<Lens>>(lens, HttpStatus.OK);
		

	}
}