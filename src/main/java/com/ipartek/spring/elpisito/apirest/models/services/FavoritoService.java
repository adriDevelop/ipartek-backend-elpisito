package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.InmuebleDAO;
import com.ipartek.spring.elpisito.apirest.models.dao.UsuarioDAO;
import com.ipartek.spring.elpisito.apirest.models.dto.FavoritoDTO;
import com.ipartek.spring.elpisito.apirest.models.dto.InmuebleDTO;
import com.ipartek.spring.elpisito.apirest.models.entities.Inmueble;
import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;

@Service
public class FavoritoService {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private InmuebleDAO inmuebleDao;
	
	public FavoritoDTO addFavorito(Long usuarioId, Long inmuebleId) {
		Inmueble inmueble = inmuebleDao.findById(inmuebleId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado el inmueble con id " + inmuebleId));
		Usuario usuario = usuarioDao.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado el usuario con id " + usuarioId));
		
		usuario.getInmueblesFavoritos().add(inmueble);
		usuarioDao.save(usuario);
		
		String nombreTipo = inmueble.getTipo().getNombre();
		String nombreLocalidad = inmueble.getLocalidad().getNombre();
		String nombreProvincia = inmueble.getLocalidad().getProvincia().getNombre();
		String nombreOperacion = inmueble.getOperacion().getNombre();
		String nombreInmobiliaria = inmueble.getInmobiliaria().getNombre();
		
		return new FavoritoDTO(inmueble.getId(), nombreTipo, nombreLocalidad, nombreProvincia, nombreOperacion, inmueble.getPrecio(), nombreInmobiliaria);
	}
	
	public FavoritoDTO deleteFavorito(Long usuarioId, Long inmuebleId) {
		Inmueble inmueble = inmuebleDao.findById(inmuebleId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado el inmueble con id " + inmuebleId));
		Usuario usuario = usuarioDao.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado el usuario con id " + usuarioId));
		
		usuario.getInmueblesFavoritos().remove(inmueble);
		usuarioDao.save(usuario);
		
		String nombreTipo = inmueble.getTipo().getNombre();
		String nombreLocalidad = inmueble.getLocalidad().getNombre();
		String nombreProvincia = inmueble.getLocalidad().getProvincia().getNombre();
		String nombreOperacion = inmueble.getOperacion().getNombre();
		String nombreInmobiliaria = inmueble.getInmobiliaria().getNombre();
		
		return new FavoritoDTO(inmueble.getId(), nombreTipo, nombreLocalidad, nombreProvincia, nombreOperacion, inmueble.getPrecio(), nombreInmobiliaria);
	}
	
	public List<FavoritoDTO> listarFavoritosCompleto(Long usuarioId){
		
		Usuario usuario = usuarioDao.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado al usuario con id " + usuarioId));
		return usuario.getInmueblesFavoritos().stream()
				.map(inmueble -> new FavoritoDTO(inmueble.getId(), inmueble.getTipo().getNombre(), inmueble.getLocalidad().getNombre(), inmueble.getLocalidad().getProvincia().getNombre(),inmueble.getOperacion().getNombre(), inmueble.getPrecio(), inmueble.getInmobiliaria().getNombre()))
				.toList();
	}
	
	// A partir de un id de Usuario devuelve los id de inmuebles favoritos
	public List<InmuebleDTO> listarFavoritos(Long usuarioId){
		
		Usuario usuario = usuarioDao.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado al usuario con id " + usuarioId));
		return usuario.getInmueblesFavoritos().stream()
				.map(inmueble -> new InmuebleDTO(inmueble.getId()))
				.toList();
	}
	
	

}
