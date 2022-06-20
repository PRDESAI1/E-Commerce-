package com.capgimini.sunglasses.controller;




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


import com.capgemini.sunglasses.model.Sunglass;

import com.capgimini.sunglasses.service.SunglassService;






@RestController
@CrossOrigin
@RequestMapping(path="/product")//mapping web requests into methods in request-handling classes
public class AdminController {
	
	
	@Autowired
	SunglassService adminSunglassService ;
	
	/**
	 * 
	 * @return list of all sunglass
	 */
	
	//http://localhost:8086/lenscart/product/getSunglass
	@RequestMapping(path="/getSunglass")
	public List<Sunglass> getSunglass(){
		List<Sunglass> SunglassList=adminSunglassService.getSunglass();
		return SunglassList;
		
	}
	
	/**
	 * adding new sunglass
	 * @param sunglass object  
	 * @return newly added glass
	 */
	
	//http://localhost:8086/lenscart/product/addSunglass
	@PostMapping(value = "/addSunglass", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Sunglass> addSunglass(@RequestBody Sunglass sunglass) { 
	 adminSunglassService.addSunglass(sunglass);
		System.out.println("add Sunglass in database");
		return ResponseEntity.ok(sunglass);
		
		
	}
	
	/**
	 * updating sunglass
	 * @param sunglass sunglass object
	 * @return updated version of sunglass
	 */
	
	//http://localhost:8086/lenscart/product/putSunglass
	@PutMapping("/putSunglass")
	public ResponseEntity<Sunglass> updateSunglass(@RequestBody Sunglass sunglass){
		System.out.println(sunglass);
		Sunglass sunglass1= adminSunglassService.updateSunglass(sunglass);
		System.out.println("update Sunglass in database");
		return new ResponseEntity<Sunglass>(sunglass1, HttpStatus.OK);
		
	}
	/**
	 * deleting sunglass by sunglassId
	 * @param sunglassId
	 * @return list of remaining sunglass
	 */
	
	//http://localhost:8086/lenscart/product/deleteSunglass/3
	@DeleteMapping(path = "/deleteSunglass/{sunglassId}", produces = "application/json")
	public ResponseEntity<List<Sunglass>> deleteSunglass(@PathVariable("sunglassId") int sunglassId) {
		List<Sunglass> sunglass= adminSunglassService.deleteSunglass(sunglassId);
		System.out.println("delete Sunglass in database");
		return new ResponseEntity<List<Sunglass>>(sunglass, HttpStatus.OK);
		
	}
	
	
	
	
			
}



