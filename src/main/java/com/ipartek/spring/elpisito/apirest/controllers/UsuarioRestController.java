package com.ipartek.spring.elpisito.apirest.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;
import com.ipartek.spring.elpisito.apirest.models.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	// Una de las características más significativas de un controlador es que sus atributos suelen
	// ser servicios.
	// Importar el servicio que es el que se encarga de hacer las peticiones
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/usuarios")
	ResponseEntity<?> findAll() {
		
		Map<String, Object> response = new LinkedHashMap<>();
		List<Usuario> resultado = new ArrayList<>();
		
		try {
			resultado = usuarioService.findAll();
		}catch(Exception e) {
			response.put("mensaje", "Ha ocurrido un error en la BBDD");
			response.put("mensaje de error", e.getMessage());
			
			return new ResponseEntity<Map <String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/usuarios-activos")
	ResponseEntity<?> findAllActive() {
		Map<String, Object> response = new LinkedHashMap<>();
		List<Usuario> resultado = new ArrayList<>();
		
		try {
			resultado = usuarioService.findAllActive();			
		}catch(Exception e) {
			response.put("mensaje", "Ha ocurrido un error en la BBDD");
			response.put("mensaje de error", e.getMessage());
			
			return new ResponseEntity<Map <String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{id}")
	ResponseEntity<?> findById(@PathVariable Long id){
		Map<String, Object> response = new LinkedHashMap<>();
		Usuario resultado = new Usuario();
		
		try {
			resultado = usuarioService.findById(id);
		}catch(Exception e) {
			response.put("mensaje", "Ha ocurrido un error en la BBDD");
			response.put("mensaje de error", e.getMessage());
			
			return new ResponseEntity<Map <String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	ResponseEntity<?> create(@RequestBody Usuario usuario){
		Map<String, Object> response = new HashMap<String, Object>();
		Usuario resultado = new Usuario();
		
		try {
			resultado = usuarioService.save(usuario);
		}catch(DataIntegrityViolationException e) {
			response.put("mensaje", "Se ha producido un error en la base de datos al intentar crear el usuario porque probablemente ya existe");
			response.put("mensaje de error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}
	
	@PutMapping("/usuario")
	ResponseEntity<?> update(@RequestBody Usuario usuario){
		Map<String, Object> response = new HashMap<String, Object>();
		Usuario resultado = new Usuario();
		
		try {
			resultado = usuarioService.save(usuario);
		}catch(DataIntegrityViolationException e) {
			response.put("mensaje", "Se ha producido un error en la base de datos al intentar modificar el usuario porque probablemente no existe");
			response.put("mensaje de error",e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Usuario>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{id}")
	ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response = new LinkedHashMap<>();
		
		try {				
				
				usuarioService.deleteById(id);
				
			
		}catch(Exception e) {
			
			response.put("mensaje de error", e.getMessage());
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Se ha eliminado correctamente", HttpStatus.OK);
		
	}
	
	

}
