package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;

public interface UsuarioService{

	// Vamos a crear unos métodos basados en el JpaRepository (por arquitectura)
	// En el JpaRepository tenemos un montón de métodos pero, aquí podemos elegir solo los que nos interesen
	
	// Método que devuelva un List<Usuario>
	List<Usuario> findAll();
	
	// Método que devuelva un List<Usuario> que estén activos
	List<Usuario> findAllActive();
	
	// Método que guardará un usuario en la BBDD
	Usuario save(Usuario usuario);
	
	// Método que devuelva a un Usuario por su id
	Usuario findById(Long id);
	
	// Método que devuelva al usuario de la BBDD y lo borre
	void deleteById(Long id);
	
}
