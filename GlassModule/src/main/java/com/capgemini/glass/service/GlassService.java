package com.capgemini.glass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.glass.daoRepository.AdminJpaRepositoryGlass;
import com.capgemini.glass.model.Glass;

@Service
public class GlassService {

	@Autowired
	AdminJpaRepositoryGlass  adminJpaRepo;
	
	// getting all list of glass
	public List<Glass> getGlass() {
	return adminJpaRepo.findAll();
	}

	// adding glass
	public Glass addGlass(Glass glass) {
	return adminJpaRepo.save(glass);
		}

	// update glass
	public Glass updateGlass(Glass glass) {
	return adminJpaRepo.saveAndFlush(glass);
	}

	// delete glass
	public List<Glass> deleteGlass(int glassId) {
	adminJpaRepo.deleteById(glassId); 
	return adminJpaRepo.findAll();
	}

}
