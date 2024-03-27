package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TypeTaxi;
import com.example.demo.service.TypeTaxiService;

@RestController
@RequestMapping("/api")
public class ControllerApi {
	@Autowired
	TypeTaxiService service;
	
	@GetMapping(value = "/")
	@ResponseBody
	public String helloWord() {
		return "World";
	}
	
	@GetMapping(value = "/type_taxi")
	@ResponseBody
	public ResponseEntity<List<TypeTaxi>> typeTaxi() {
        List<TypeTaxi> typeTaxiList = service.getAll();
        if (typeTaxiList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devolver 404 si la lista está vacía
        } else {
            return new ResponseEntity<>(typeTaxiList, HttpStatus.OK); // Devolver 200 y la lista de tipos de taxi
        }
    }
	
	@PostMapping(value = "/type_taxi/create")
	@ResponseBody
	public TypeTaxi createTaxi(@RequestBody TypeTaxi newType) {
		return service.save(newType);
	}
	
	@GetMapping("/error")
	public String error() {
		return "Something Way Wrong";
	} 
}
