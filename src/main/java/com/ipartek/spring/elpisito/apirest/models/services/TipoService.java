package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

public interface TipoService {

	public Optional<Tipo> findById(Long id) throws Exception;
	
	public List<Tipo> findAll();
	
	public void save(Tipo tipo);
	
	public void deleteById(Long id) throws Exception;
}
