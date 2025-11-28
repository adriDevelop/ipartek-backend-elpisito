package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.entities.Inmueble;
import com.ipartek.spring.elpisito.apirest.models.services.InmuebleServiceImpl;

@RestController
@RequestMapping("/api")
public class InmuebleRestController {
	
	@Autowired
	InmuebleServiceImpl inmuebleService;
	
	@GetMapping("/inmueble/{id}")
	public ResponseEntity<Inmueble> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.findById(id));
	}
	
	@GetMapping("/inmuebles-activos")
	public ResponseEntity<List<Inmueble>> findByActivo(){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.findAllActivo());
	}
	
	@GetMapping("/inmuebles")
	public ResponseEntity<List<Inmueble>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.findAll());
	}
	
	@GetMapping("/inmuebles-portada")
	public ResponseEntity<List<Inmueble>> findAllPortada(){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.findAllPortada());
	}
	
	@GetMapping("/inmuebles/{idTipo}/{idLocalidad}/{idOperacion}")
	public ResponseEntity<List<Inmueble>> finder(@PathVariable Long idTipo, @PathVariable Long idLocalidad, @PathVariable Long idOperacion){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.finder(idTipo, idOperacion, idLocalidad));
	}
	
	@GetMapping("/inmuebles/{idInmobiliaria}")
	public ResponseEntity<List<Inmueble>> finderInmueblesInmobiliaria(@PathVariable Long idInmobiliaria){
		return ResponseEntity.status(HttpStatus.OK).body(inmuebleService.findByInmobiliaria(idInmobiliaria));
	}
	
	@PutMapping("/inmueble")
	public ResponseEntity<Inmueble> update(@RequestBody Inmueble inmueble){
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.save(inmueble));
	}
	
	@PostMapping("/inmueble")
	public ResponseEntity<Inmueble> save(@RequestBody Inmueble inmueble){
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.save(inmueble));
	}

}
