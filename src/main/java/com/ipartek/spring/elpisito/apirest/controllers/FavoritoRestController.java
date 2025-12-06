package com.ipartek.spring.elpisito.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.spring.elpisito.apirest.models.dto.FavoritoDTO;
import com.ipartek.spring.elpisito.apirest.models.dto.InmuebleDTO;
import com.ipartek.spring.elpisito.apirest.models.services.FavoritoService;

@RestController
@RequestMapping("/api")
public class FavoritoRestController {
	
	@Autowired
	FavoritoService favoritoService;
	
	@PostMapping("/usuario-inmueble")
	public ResponseEntity<FavoritoDTO> inmueblesFavoritos(@RequestParam(name="usuid") Long usuarioId, @RequestParam(name="inmid") Long inmuebleId){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoService.addFavorito(usuarioId, inmuebleId));
	}
	
	@DeleteMapping("/usuario-inmueble/{idUsuario}/{idInmueble}")
	public ResponseEntity<FavoritoDTO> deleteInmuebleFavorito(@PathVariable Long usuarioId, @PathVariable Long inmuebleId){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoService.deleteFavorito(usuarioId, inmuebleId));
	}
	
	@GetMapping("/usuario-inmueble/{idUsuario}")
	public ResponseEntity<List<InmuebleDTO>> listarFavoritos(@PathVariable Long idUsuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoService.listarFavoritos(idUsuario));
	}
	
	@GetMapping("/usuario-inmueble-completo/{idUsuario}")
	public ResponseEntity<List<FavoritoDTO>> listarFavoritosCompleto(@PathVariable Long idUsuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoService.listarFavoritosCompleto(idUsuario));
	}

}
