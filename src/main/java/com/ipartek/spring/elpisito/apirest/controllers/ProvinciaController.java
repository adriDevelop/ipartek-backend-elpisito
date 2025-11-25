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

import com.ipartek.spring.elpisito.apirest.models.entities.Provincia;
import com.ipartek.spring.elpisito.apirest.models.services.ProvinciaServiceImpl;

@RestController
@RequestMapping("/api")
public class ProvinciaController {
	
	@Autowired
	ProvinciaServiceImpl provinciasService;
	
	@GetMapping("/provincia/{id}")
	public ResponseEntity<Provincia> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(provinciasService.findById(id));
	}
	
	@GetMapping("/provincias")
	public ResponseEntity<List<Provincia>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(provinciasService.findAll());
	}
	
	@PostMapping("/provincia")
	public ResponseEntity<Provincia> save(@RequestBody Provincia provincia){
		return ResponseEntity.status(HttpStatus.CREATED).body(provinciasService.save(provincia));
	}
	
	@PutMapping("/provincia")
	public ResponseEntity<Provincia> update(@RequestBody Provincia provincia){
		return ResponseEntity.status(HttpStatus.CREATED).body(provinciasService.save(provincia));
	}
}
