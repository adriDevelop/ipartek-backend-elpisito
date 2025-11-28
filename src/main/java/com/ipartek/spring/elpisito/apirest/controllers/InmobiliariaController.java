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

import com.ipartek.spring.elpisito.apirest.models.entities.Inmobiliaria;
import com.ipartek.spring.elpisito.apirest.models.services.InmobiliariaServiceImpl;

@RestController
@RequestMapping("/api")
public class InmobiliariaController {

	
	@Autowired
	InmobiliariaServiceImpl inmobiliariaDao;
	
	@GetMapping("/inmobiliaria/{id}")
	public ResponseEntity<Inmobiliaria> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(inmobiliariaDao.findById(id));
	}
	
	@GetMapping("/inmobiliarias")
	public ResponseEntity<List<Inmobiliaria>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(inmobiliariaDao.findAll());
	}
	
	@GetMapping("/inmobiliarias-activas")
	public ResponseEntity<List<Inmobiliaria>> findAllActivas(){
		return ResponseEntity.status(HttpStatus.OK).body(inmobiliariaDao.findAllActivo());
	}
	
	@PostMapping("/inmobiliaria")
	public ResponseEntity<Inmobiliaria> save(@RequestBody Inmobiliaria inmobiliaria){
		return ResponseEntity.status(HttpStatus.CREATED).body(inmobiliariaDao.save(inmobiliaria));
	}
	
	@PutMapping("/inmobiliaria")
	public ResponseEntity<Inmobiliaria> update(@RequestBody Inmobiliaria inmobiliaria){
		return ResponseEntity.status(HttpStatus.CREATED).body(inmobiliariaDao.save(inmobiliaria));
	}
}
