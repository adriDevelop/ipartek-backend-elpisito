package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;
import com.ipartek.spring.elpisito.apirest.models.services.TipoImpl;

import jakarta.websocket.server.PathParam;
 
@RestController
@RequestMapping("/api")
public class TipoController {

	@Autowired
	private TipoImpl tipoService;
	
	// Get Tipo por id
	@GetMapping("/tipo/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		// Necesito un map para mostrar los errores que pueda mostrar este método
		Map<String, Object> response = new HashMap<>();
		Tipo respuesta = new Tipo();
		
		try { 
			
			respuesta = tipoService.findById(id).get();
			
		}catch(Exception e) {
			response.put("mensaje de error", "No se ha podido realizar la petición de búsqueda");
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Tipo>(respuesta, HttpStatus.OK);
	}
	
	// Get all tipos
	@GetMapping("/tipos")
	public ResponseEntity<?> findAll(){
		
				Map<String, Object> response = new HashMap<>();
				List<Tipo> respuesta = new ArrayList<>();
				
				try {
					
					respuesta = tipoService.findAll();
					
				}catch(Exception e) {
					response.put("mensaje de error", "No se ha podido realizar la petición de búsqueda");
					response.put("mensaje", e.getMessage());
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
				
				return new ResponseEntity<List<Tipo>>(respuesta, HttpStatus.OK);
	}
	
	// Guardar un tipo
	@PostMapping("/tipo")
	public ResponseEntity<?> save(@RequestBody Tipo tipo){
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoService.save(tipo);
		}catch(Exception e) {
			response.put("mensaje de error", "No se ha podido realizar el agregado");
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Tipo>(tipo, HttpStatus.OK);
	}
	
	// Actualizar un tipo
	@PutMapping("/tipo")
	public ResponseEntity<?> update(@RequestBody Tipo tipo){
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoService.save(tipo);
		}catch(Exception e) {
			response.put("mensaje de error", "No se ha podido realizar la actualización del objeto");
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Tipo>(tipo, HttpStatus.OK);
	}
}
