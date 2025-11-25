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

import com.ipartek.spring.elpisito.apirest.models.entities.Operacion;
import com.ipartek.spring.elpisito.apirest.models.services.OperacionServiceImpl;

@RestController
@RequestMapping("/api")
public class OperacionController {

	@Autowired
	OperacionServiceImpl operacionService;
	
	@GetMapping("/operacion/{id}")
	public ResponseEntity<Operacion> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(operacionService.findById(id));
	}
	
	@GetMapping("/operaciones")
	public ResponseEntity<List<Operacion>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(operacionService.findAll());
	}
	
	@GetMapping("/operaciones-activas")
	public ResponseEntity<List<Operacion>> findAllActive(){
		return ResponseEntity.status(HttpStatus.OK).body(operacionService.findAllActivo());
	}
	
	@PostMapping("/operacion")
	public ResponseEntity<Operacion> save(@RequestBody Operacion operacion){
		return ResponseEntity.status(HttpStatus.OK).body(operacionService.save(operacion));
	}
	
	@PutMapping("/operacion")
	public ResponseEntity<Operacion> update(@RequestBody Operacion operacion){
		return ResponseEntity.status(HttpStatus.OK).body(operacionService.save(operacion));
	}
}
