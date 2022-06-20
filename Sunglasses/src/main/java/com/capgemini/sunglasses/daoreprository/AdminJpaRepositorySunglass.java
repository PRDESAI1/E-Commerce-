package com.capgemini.sunglasses.daoreprository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.sunglasses.model.Sunglass;



@Repository
public interface AdminJpaRepositorySunglass extends JpaRepository<Sunglass,Integer>{
	
}
