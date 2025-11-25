package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import com.ipartek.spring.elpisito.apirest.models.entities.Operacion;

public interface GeneralService <T> {

	public T findById(Long id);
	
	public List<T> findAll();
	
	public T save(T tipo);
	
	public void deleteById(Long id) throws Exception;

	public List<T> findAllActivo();
	
}
