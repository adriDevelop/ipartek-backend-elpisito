package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.ArrayList;
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

import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;
import com.ipartek.spring.elpisito.apirest.models.services.UsuarioServiceImpl;

// Cuando un controlador recibe los datos del servicio ( no se ha producido ningún error etc)
// La API siempre manda automáticamente un 200 a Cliente.
// Pero si quieremos personalizar la respuesta: 200, 201, 202... también podemos hacerlo.

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
		List<Usuario> resultado = usuarioService.findAll();
		
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/usuarios-activos")
	ResponseEntity<?> findAllActive() {
		List<Usuario> resultado = new ArrayList<>();
		
		resultado = usuarioService.findAllActive();
		
		return new ResponseEntity<List<Usuario>>(resultado, HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{id}")
	ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
	}
	
	@PostMapping("/usuario")
	ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PutMapping("/usuario")
	ResponseEntity<?> update(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
	}
	
	
	
	

}
