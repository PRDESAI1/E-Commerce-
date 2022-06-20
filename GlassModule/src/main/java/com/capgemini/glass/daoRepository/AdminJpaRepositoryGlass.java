package com.capgemini.glass.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.glass.model.Glass;

@Repository
public interface AdminJpaRepositoryGlass extends JpaRepository<Glass,Integer>{

}
