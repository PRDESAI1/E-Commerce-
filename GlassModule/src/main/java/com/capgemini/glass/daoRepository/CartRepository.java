package com.capgemini.glass.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.glass.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}
