package com.capgimini.sunglasses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.sunglasses.daoreprository.AdminJpaRepositorySunglass;
import com.capgemini.sunglasses.model.Sunglass;


@Service
public class SunglassService {
	@Autowired
	AdminJpaRepositorySunglass adminJpaRepositorySunglass;

	// getting all list of sunglass
	public List<Sunglass> getSunglass() {
		return adminJpaRepositorySunglass.findAll();
	}

	// adding sunglass
	public Sunglass addSunglass(Sunglass sunglass) {
		return adminJpaRepositorySunglass.save(sunglass);
	}

	// update sunglass
	public Sunglass updateSunglass(Sunglass sunglass) {
		return adminJpaRepositorySunglass.saveAndFlush(sunglass);
	}

	// delete sunglass
	public List<Sunglass> deleteSunglass(int sunglassId) {
		adminJpaRepositorySunglass.deleteById(sunglassId);
		return adminJpaRepositorySunglass.findAll();
	}

}
