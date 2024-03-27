package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TypeTaxi;
import com.example.demo.repository.ITypeTaxiRepository;

@Service
public class TypeTaxiService {
	@Autowired
	ITypeTaxiRepository dao;
	
	public List<TypeTaxi> getAll() {
		return dao.findAll();
	}
	
	public TypeTaxi save(TypeTaxi typeTaxi) {
		return dao.saveAndFlush(typeTaxi);
	}
}
