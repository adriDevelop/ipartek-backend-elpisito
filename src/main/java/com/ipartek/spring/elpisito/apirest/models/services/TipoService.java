package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

public interface TipoService {

	public Tipo findById(Long id);
	
	public List<Tipo> findAll();
	
	public void save(Tipo tipo);
	
	public void deleteById(Long id) throws Exception;
}
