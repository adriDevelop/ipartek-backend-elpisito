package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;
import com.ipartek.spring.elpisito.apirest.models.services.TipoImpl;

@RestController
@RequestMapping("/api")
public class TipoController {

	@Autowired
	private TipoImpl tipoService;

	// Get Tipo por id
	@GetMapping("/tipo/{id}")
	public ResponseEntity<Tipo> findById(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(tipoService.findById(id));
	}

	// Get all tipos
	@GetMapping("/tipos")
	public ResponseEntity<List<Tipo>> findAll() {

		return ResponseEntity.status(HttpStatus.OK).body(tipoService.findAll());
	}

	// Guardar un tipo
	@PostMapping("/tipo")
	public ResponseEntity<Tipo> save(@RequestBody Tipo tipo) {

		return ResponseEntity.status(HttpStatus.CREATED).body(tipoService.save(tipo));
	}

	// Actualizar un tipo
	@PutMapping("/tipo")
	public ResponseEntity<Tipo> update(@RequestBody Tipo tipo) {

		return ResponseEntity.status(HttpStatus.OK).body(tipoService.save(tipo));
	}
}
