package com.capgemini.ecommarce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ecommarce.entity.Carts;
import com.capgemini.ecommarce.entity.Frame;
import com.capgemini.ecommarce.repository.CartRepository;
import com.capgemini.ecommarce.repository.FrameRepo;
import com.capgemini.ecommarce.service.CartService;
import com.capgemini.ecommarce.service.FrameService;

@SpringBootTest
class FrameApplicationTests {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	FrameService frameService;
	
	@MockBean
	CartRepository cartRepository;
	
	@MockBean
	FrameRepo frameRepo;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void saveFrameTest() {
		Carts cart=new Carts();
		Frame p=new Frame(4,"rim","blue",900,"make more confident","shape","s",cart);
		//Product p2=new Product(29,"HD",45,900000,null);
		when(frameRepo.save(p)).thenReturn(p);
		assertEquals(p,frameService.addFrame(p));
		
	}
	
	@Test
	public void deleteFrameTest() {
		Carts cart=new Carts();
		Frame p=new Frame(103,"rim","blue",900,"make more confident","shape","s",cart);
		
		frameService.deleteFrame(103);
		verify(frameRepo,times(1)).deleteById(103);
	
	}
	
	@Test
	public void updateFrameTest() {
		Carts cart=new Carts();
		Frame p1=new Frame(4,"d","blue",900,"make more confident","shape","s",cart);
		when(frameRepo.saveAndFlush(p1)).thenReturn(p1);
		assertEquals(p1,frameService.updateFrame(p1));
		
	
	}
	
	@Test
	public void addToCartTest() {
		List<Frame> frame=new ArrayList<>() ;
		
		Carts p=new Carts(1,233,"debitCard",frame);
		
		when(cartRepository.save(p)).thenReturn(p);
		assertEquals(p,cartService.addToCart(p));
		
	}
	
	@Test
	public void deleteFromCartTest() {
		List<Frame> frame=new ArrayList<>() ;
		
		Carts p=new Carts(103,233,"debitCard",frame);
		
		cartService.deleteFromCart(103);
		verify(cartRepository,times(1)).deleteById(103);
	
	}
	
	@Test
	public void updateIntoCartTest() {
		List<Frame> frame=new ArrayList<>() ;
		
		Carts p=new Carts(103,233,"debitCard",frame);
		when(cartRepository.saveAndFlush(p)).thenReturn(p);
		assertEquals(p,cartService.updateInCart(p));
		
	
	}

}
