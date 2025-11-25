package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ipartek.spring.elpisito.apirest.exceptions.ApiExceptionHandler;
import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.UsuarioDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements GeneralService<Usuario>{

    private final ApiExceptionHandler apiExceptionHandler;
	
	// Una de las principales características de un @Service es que sus atributos suelen ser (no siempre) DAOs 
	// (repositorios)
	
	@Autowired
	private UsuarioDAO usuarioDao;

    UsuarioServiceImpl(ApiExceptionHandler apiExceptionHandler) {
        this.apiExceptionHandler = apiExceptionHandler;
    }
	// usuarioDao automáticamente tiene todos los métodos implementados por hibernate de JpaRepository
	// ¿Dónde están implementados? La implementación la ha hecho hibernate en el contexto de Spring.
	// Se ha creado en el contexto una clase implementadora de UsuarioDao y en esa implementación
	// se ha puesto toda la lógica SQL sin que hayamos tocado una sola línea de código SQL.

	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioDao.findAll();
		return usuarios;
	}
	
	public List<Usuario> findAllActive() {
		return usuarioDao.findByActivo(1);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// Este método recibe un usuario
		// Si el usuario que recibimos tiene id hibernate considera que es un update
		// Si el usuario que recibe el método no tiene id hibernate considera que es un create
		// Podemos concluir que el CrudRepository solo tiene un método save para ambas tareas
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario findById(Long id) {
		
		return usuarioDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado al usuario con id " + id));
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		Optional<Usuario> usuario = usuarioDao.findById(id);
		
		if (usuario.isPresent()) {
			usuarioDao.deleteById(id);
		}else {
			throw new Exception("Usuario no encontrado");
		}
	}

	@Override
	public List<Usuario> findAllActivo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
