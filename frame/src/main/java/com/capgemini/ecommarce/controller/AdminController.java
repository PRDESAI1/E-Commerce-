package com.capgemini.ecommarce.controller;

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

import com.capgemini.ecommarce.entity.Frame;
import com.capgemini.ecommarce.service.FrameService;

@RestController
@CrossOrigin
@RequestMapping(path="/product")//mapping web requests onto methods in request-handling classes
public class AdminController {
	
	@Autowired
	FrameService adminService;
	
	
	
	
	
		
	/***************************************Frame**********************************************/
	
	/**
	 * adding new frame
	 * @param frame  frame object
	 * @return newly added frame
	 */
	//http://localhost:8086/lenscart/product/addFrame
	@PostMapping(value = "/addFrame", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frame) { 
		adminService.addFrame(frame);
		System.out.println("add frame in database");
		return ResponseEntity.ok(frame);
			
	}
	
	
	/**
	 * updating frame
	 * @param frame frame object
	 * @return updated version of frame
	 */
	//http://localhost:8086/lenscart/product/putFrame
	@PutMapping("/putFrame")
	public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame){
		System.out.println(frame);
		Frame frame1= adminService.updateFrame(frame);
		System.out.println("update frame in database");
		return new ResponseEntity<Frame>(frame1, HttpStatus.OK);
		
	}
	/**
	 * deleting frame by frameId
	 * @param frameId 
	 * @return list of remaining frames
	 */
	
	//http://localhost:8086/lenscart/product/1
	@DeleteMapping(path = "/deleteFrame/{frameId}", produces = "application/json")
	public ResponseEntity<List<Frame>> deleteFrame(@PathVariable("frameId") int frameId) {
		List<Frame> frame= adminService.deleteFrame(frameId);
		System.out.println("delete frame in database");
		return new ResponseEntity<List<Frame>>(frame, HttpStatus.OK);
		
	}
}