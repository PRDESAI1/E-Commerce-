package com.capgemini.glass;

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

import com.capgemini.glass.daoRepository.AdminJpaRepositoryGlass;
import com.capgemini.glass.daoRepository.CartRepository;
import com.capgemini.glass.model.Cart;
import com.capgemini.glass.model.Glass;
import com.capgemini.glass.service.CartService;
import com.capgemini.glass.service.GlassService;

@SpringBootTest
class GlassModuleApplicationTests {

	@Autowired
	GlassService adminGlassService;
	@MockBean
	AdminJpaRepositoryGlass adminJpaRepo;
	@Autowired
	CartService cartService;
	@MockBean
	CartRepository cartRepository;
	
	@Test
	public void saveGlassTest() {
	Cart cart=new Cart();
	Glass p=new Glass(105,"flint","gucci",2340,"classy","single vision",8, cart);
	when(adminJpaRepo.save(p)).thenReturn(p);
	assertEquals(p,adminGlassService.addGlass(p));
	}
	
	@Test
	public void deleteGlassTest() {
	Cart cart=new Cart();
	Glass p=new Glass(103,"flint","burberry",1700,"classy","bifocal",8, cart);
	adminGlassService.deleteGlass(103);
	verify(adminJpaRepo,times(1)).deleteById(103);
	}

	@Test
	public void updateGlassTest() {
	Cart cart=new Cart();
	Glass p=new Glass(103,"flint","burberry",1700,"classy","bifocal",8, cart);
	when(adminJpaRepo.saveAndFlush(p)).thenReturn(p);
	assertEquals(p,adminGlassService.updateGlass(p));
	}
	
	@Test
	public void addToCartTest() {
		List <Glass> glass=new ArrayList<>();
		Cart p=new Cart(1,233,"debitCard", glass);
		when(cartRepository.save(p)).thenReturn(p);
		assertEquals(p,cartService.addToCart(p));
		
	}
	
	@Test
	public void deleteFromCartTest() {
		List <Glass> glass=new ArrayList<>();
		Cart p=new Cart(103,233,"debitCard", glass);
		cartService.deleteFromCart(103);
		verify(cartRepository,times(1)).deleteById(103);
	
	}
	
	@Test
	public void updateIntoCartTest() {
		List <Glass> glass=new ArrayList<>();
		Cart p=new Cart(103,233,"debitCard", glass);
		when(cartRepository.saveAndFlush(p)).thenReturn(p);
		assertEquals(p,cartService.updateInCart(p));
	}
}
