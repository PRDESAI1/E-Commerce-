package com.capgemini.lens.daorepository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capgemini.lens.model.Lens;



@Repository
	public interface AdminJpaRepositoryLens extends JpaRepository<Lens,Integer> {

		
		
	}

