package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.entities.ImagenInmueble;
import com.ipartek.spring.elpisito.apirest.models.services.ImagenInmuebleService;

@RestController
@RequestMapping("/api")
public class ImagenInmuebleController {
	
	@Autowired
	private ImagenInmuebleService imagenService;
	
	@GetMapping("/imagen/{id}")
	public ResponseEntity<ImagenInmueble> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(imagenService.findById(id));
	}
	
	@GetMapping("/imagenes")
	public ResponseEntity<List<ImagenInmueble>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(imagenService.findAll());
	}
	
	@GetMapping("/imagenes-activas")
	public ResponseEntity<List<ImagenInmueble>> findAllActivas(){
		return ResponseEntity.status(HttpStatus.OK).body(imagenService.findAllActivo());
	}
	
	@PostMapping("/imagen")
	public ResponseEntity<ImagenInmueble> save(@RequestBody ImagenInmueble imagen){
		return ResponseEntity.status(HttpStatus.OK).body(imagenService.save(imagen));
	}
	
	@PutMapping("/imagen")
	public ResponseEntity<ImagenInmueble> update(@RequestBody ImagenInmueble imagen){
		return ResponseEntity.status(HttpStatus.OK).body(imagenService.save(imagen));
	}
	
	@DeleteMapping("/imagen/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		imagenService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado correctamente");
	}
}
