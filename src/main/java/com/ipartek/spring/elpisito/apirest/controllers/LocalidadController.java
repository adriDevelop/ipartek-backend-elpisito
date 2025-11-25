package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.entities.Localidad;
import com.ipartek.spring.elpisito.apirest.models.services.LocalidadServiceImpl;

@RestController
@RequestMapping("/api")
public class LocalidadController {

	@Autowired
	private LocalidadServiceImpl service;
	
	@GetMapping("/localidad/{id}")
	public ResponseEntity<Localidad> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/localidades")
	public ResponseEntity<List<Localidad>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PostMapping("/localidad")
	public ResponseEntity<Localidad> save(@RequestBody Localidad localidad){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(localidad));
	}
	
	@PutMapping("/localidad")
	public ResponseEntity<Localidad> update(@RequestBody Localidad localidad){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(localidad));
	}
	
	
}
