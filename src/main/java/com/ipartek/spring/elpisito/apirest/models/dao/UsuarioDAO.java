package com.ipartek.spring.elpisito.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.spring.elpisito.apirest.models.entities.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	
	// Hibernate implementa los datos de CrudRepository
	
	// Cuando necesitemos que hibernate implemente métodos que no están en el CrudRepository o en el JpaRepository 
	// podemos utilizar derived query methods
	// El secreto deriva del nombre del método
	List<Usuario> findByActivo(Integer activo);
}