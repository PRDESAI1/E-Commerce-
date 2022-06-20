package com.capgemini.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ecommarce.entity.Carts;

public interface CartRepository extends JpaRepository<Carts,Integer> {

}
